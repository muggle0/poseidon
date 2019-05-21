package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.*;
import com.muggle.poseidon.entity.vo.UserVO;
import com.muggle.poseidon.manager.UserInfoManagerImpl;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
import com.muggle.poseidon.repos.UserRoleRepository;
import com.muggle.poseidon.service.PoseidonUserdetailService;
import com.muggle.poseidon.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-24 21:01
 **/
@Service
@Slf4j
public class PoseidonUserdetailsServiceImpl implements UserDetailsService, PoseidonUserdetailService {
    @Autowired
    PoseidonUserDetailsRepository repository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    PoseidonSignRepository signRepository;
    @Autowired
    RedisService redisService;
    @Autowired
    RoleServiceImpl roleServiceImpl;
    @Autowired
    UserRoleRepository userRoleRepository;


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PoseidonUserDetail userDetail = repository.findByUsernameAndDeleteTimeIsNull(s);
        if (userDetail == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        Set<Role> roles = userDetail.getRoles();
//        log.info("用户登录验证：" + userDetail.getId());
        if (roles == null) {
            return userDetail;
        }
        Iterator<Role> iterator = roles.iterator();
        Set<PoseidonGrantedAuthority> authorities = new HashSet<>();
        while (iterator.hasNext()) {
            authorities.addAll(iterator.next().getAuthorities());
        }
        userDetail.setAuthorities(authorities);
        return userDetail;
    }

    @Transactional
    public ResultBean toSignUp(PoseidonUserDetail userDetail) {
//        log.info("尝试创建用户：" + userDetail.toString());
        String value = userDetail.getPassword();
        String password = passwordEncoder.encode(userDetail.getPassword());
        userDetail.setPassword(password);
        userDetail.setCreatTime(new Date()).setEnabled(true)
                .setAccountNonExpired(true).setAccountNonLocked(true).setCredentialsNonExpired(true);
        PoseidonUserDetail byUsernameAndDeleteTimeIsNull = repository.findByUsernameAndDeleteTimeIsNull(userDetail.getUsername());
        if (byUsernameAndDeleteTimeIsNull!=null){
            return ResultBean.getInstance("500","用户名已存在");
        }
        PoseidonUserDetail save = repository.save(userDetail);
        Role role = new Role().setRoleCode("base");
        List<Role> all = roleServiceImpl.findAll(role);
        saveUserRole(all, save.getId());
        log.info("新增用户：{}  pass:{}", save.toString(),value);
        final Set<PoseidonGrantedAuthority> authorities = all.get(0).getAuthorities();
//        自动登录
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(save, save.getPassword(),authorities );
        UserInfoManagerImpl.setUser(usernamePasswordAuthenticationToken);
        return ResultBean.getInstance(save);
    }

    @Transactional
    public Optional<PoseidonUserDetail> findOne(String id) {
        Optional<PoseidonUserDetail> one = repository.findOne((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), id));
            return criteriaQuery.where(predicate).getRestriction();
        });
        return one;
    }

    public PoseidonSign loadByPrincipal(String principal) {
        PoseidonSign poseidonSign = signRepository.findByPrincipalAndDeleteTimeIsNull(principal);
        if (poseidonSign == null) {
            throw new UsernameNotFoundException("账户信息不存在");
        }
//        获取校验码
//        String credentials = oauthService.getCredentialsByPrincipal(principal);
        return poseidonSign;
    }


    public Long count(PoseidonUserDetail userDetail) {
        final long count = repository.count((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            if (userDetail.getUsername() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("username"), userDetail.getUsername()));
            }
            if (userDetail.getNickname() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("nickname"), userDetail.getNickname()));
            }
            if (userDetail.getPhone() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("phone"), userDetail.getPhone()));
            }
            if (userDetail.getEmail() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("email"), userDetail.getEmail()));
            }
            if (userDetail.getGender() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("gender"), userDetail.getGender()));
            }

            return criteriaQuery.where(predicate).getRestriction();
        });
        return count;
    }

    //  保存用户角色中间表
    void saveUserRole(List<Role> roles, String id) {
        List<UserRole> list = new ArrayList<>();
        roles.forEach(role -> {
            UserRole userRole = new UserRole();
            userRole.setAccreditId("0");
            userRole.setRoleId(role.getId()).setUserId(id);
            list.add(userRole);
        });
        userRoleRepository.saveAll(list);
    }

    @Transactional
    @Override
    public ResultBean getUsersByRoleId(String roleId) {
        List<UserRole> byRoleId = userRoleRepository.findByRoleId(roleId);
        List<UserVO> userVOS = new ArrayList<>();
        byRoleId.forEach(userRole -> {
            UserVO userVO = new UserVO();
            Optional<PoseidonUserDetail> byId = findOne(userRole.getUserId());
            BeanUtils.copyProperties(byId.get(), userVO);
            userVOS.add(userVO);
        });
        return ResultBean.getInstance(userVOS);
    }

    @Transactional
    @Override
    public ResultBean getUserById(String id) {
        Optional<PoseidonUserDetail> one = findOne(id);
        if (one.isPresent()) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(one.get(), userVO);
            return ResultBean.getInstance(userVO);
        }
        return ResultBean.getInstance("500", "用户信息不存在");
    }

    @Transactional
    @Override
    public ResultBean update(UserVO userVO, String oldPassword, String newPassword) {
        PoseidonUserDetail user = UserInfoManagerImpl.getUser();
        if (!userVO.getId().equals(user.getId())) {
            return ResultBean.getInstance("500", "信息异常，请确认账号信息");
        }
        String password = null;
        if (oldPassword != null && newPassword != null) {
            if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
                return ResultBean.getInstance("500", "密码错误");
            }
            password = passwordEncoder.encode(newPassword);
        }
        BeanUtils.copyProperties(userVO, user);
        user.setUpdateTime(new Date()).setPassword(password).setEnabled(true);
        repository.save(user);
        log.info("更新用户信息: " + userVO.toString());
        return ResultBean.getInstance();
    }

    @Transactional
    @Override
    public ResultBean delete() {
        PoseidonUserDetail user = UserInfoManagerImpl.getUser();
        user.setDeleteTime(new Date());
        repository.save(user);
        log.info("删除用户：" + user.toString());
        return ResultBean.getInstance();
    }
}
