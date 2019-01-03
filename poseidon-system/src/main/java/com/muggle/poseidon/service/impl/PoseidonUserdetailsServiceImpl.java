package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.core.properties.TokenProperties;
import com.muggle.poseidon.model.*;
import com.muggle.poseidon.model.vo.UserVO;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
import com.muggle.poseidon.repos.UserRoleRepository;
import com.muggle.poseidon.service.PoseidonUserdetailService;
import com.muggle.poseidon.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.muggle.poseidon.core.properties.PoseidonProperties;

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
// todo 检查代码
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PoseidonUserDetail userDetail = repository.findDistinctByUsername(s);
        if (userDetail == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        Set<Role> roles = userDetail.getRoles();
        log.info("用户登录验证：" + userDetail.toString());
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
    public ResultBean toSignUp(PoseidonUserDetail userDetail, String verification) {
        String key = TokenProperties.VERIFICATION + "-" + userDetail.getUsername();
        String s = redisService.get(key);
        if (s == null) {
            throw new PoseidonException("验证码过期", PoseidonProperties.COMMIT_DATA_ERROR);
        }
        if (!verification.equals(s)) {
            throw new PoseidonException("验证码错误", PoseidonProperties.COMMIT_DATA_ERROR);
        }

        log.info("创建用户：" + userDetail.toString());
        String value = userDetail.getPassword();
        String password = passwordEncoder.encode(userDetail.getPassword());
        userDetail.setPassword(password);
        userDetail.setCreatTime(new Date()).setEnabled(true)
                .setAccountNonExpired(true).setAccountNonLocked(true).setCredentialsNonExpired(true);
        try {
            PoseidonUserDetail save = repository.save(userDetail);
            Role role = new Role().setRoleCode("base");
            List<Role> all = roleServiceImpl.findAll(role);
            saveUserRole(all, save.getId());
            log.info("新增用户：{}", save.toString());
            return ResultBean.getInstance(save);
        } catch (Exception e) {
            return ResultBean.getInstance(PoseidonProperties.COMMIT_DATA_ERROR, "用户名已存在");
        }
    }

    public UserDetails findOne(String id) {
        Optional<PoseidonUserDetail> userDetail = repository.findById(id);
        return userDetail.get();
    }

    public PoseidonSign loadByPrincipal(String principal) {
        PoseidonSign poseidonSign = signRepository.findByPrincipal(principal);
//        获取校验码
//        String credentials = oauthService.getCredentialsByPrincipal(principal);
        String key = TokenProperties.VERIFICATION + "-" + principal;
        String credentials = redisService.get(key);
        poseidonSign.setCredentials(credentials);
        return poseidonSign;
    }


    public Long count(PoseidonUserDetail userDetail) {
        final long count = repository.count((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNull(root.get("deleteTime"));
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("enabled"), true));
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

    @Override
    public ResultBean getUsersByRoleId(String roleId) {
        List<UserRole> byRoleId = userRoleRepository.findByRoleId(roleId);
        List<UserVO> userVOS=new ArrayList<>();
        byRoleId.forEach(userRole -> {
            UserVO userVO=new UserVO();
            Optional<PoseidonUserDetail> byId = repository.findById(userRole.getUserId());
            BeanUtils.copyProperties(byId.get(),userVO);
            userVOS.add(userVO);
        });
        return ResultBean.getInstance(userVOS);
    }


}
