package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.*;
import com.muggle.poseidon.model.vo.RoleVO;
import com.muggle.poseidon.repos.PoseidonRoleRepository;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
import com.muggle.poseidon.repos.RoleGrantedRepository;
import com.muggle.poseidon.repos.UserRoleRepository;
import com.muggle.poseidon.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@Slf4j
public class RoleServiceImpl {
    @Autowired
    PoseidonRoleRepository poseidonRoleRepository;
    @Autowired
    PoseidonUserDetailsRepository userDetailsRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    RoleGrantedRepository roleGrantedRepository;


    @Transactional
    public List<Role> findAll(Role role) {
         List<Role> all = poseidonRoleRepository.findAll((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            if (role.getRoleCode() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("roleCode"), role.getRoleCode()));
            }
            if (role.getName() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("name"), role.getName()));
            }
            if (role.getId() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("id"), role.getId()));
            }
            return query.where(predicate).getRestriction();
        });
        return all;
    }

    @Transactional
    public ResultBean getRoles() {
        Role role = new Role();
        List<Role> all = findAll(role);
        List<RoleVO> roleVOList = new ArrayList<>();
        all.forEach(vaule -> {
            if (vaule.isEnable()) {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(vaule, roleVO);
                roleVOList.add(roleVO);
            }
        });
        return ResultBean.getInstance(roleVOList);
    }
    public ResultBean findOne(String id) {
        Optional<Role> one = poseidonRoleRepository.findOne((root, query, builder) -> {
            Predicate predicate = builder.isNull(root.get("deleteTime"));
            predicate=builder.and(predicate,builder.equal(root.get("id"),id));
            return query.where(predicate).getRestriction();
        });
       if (one.isPresent()){
           return ResultBean.getInstance(one.get());
       }
       return ResultBean.getInstance("500","没有数据");
    }

    @Transactional
    public ResultBean insertUserRole(UserRole userRole) {
        PoseidonUserDetail details = (PoseidonUserDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
        Set<Role> roles = details.getRoles();
        String roleCode = null;
        Iterator<Role> iterator = roles.iterator();
        while (iterator.hasNext()) {
            Role next = iterator.next();
            if (next.getId().equals(userRole.getRoleId())) {
                roleCode = next.getRoleCode();
                break;
            }
        }
        if (roleCode == null) {
            return ResultBean.getInstance("500", "分配失败，没有权限");
        }

        Optional<PoseidonUserDetail> byId = userDetailsRepository.findById(userRole.getUserId());
        Set<Role> custRoles = byId.get().getRoles();
        String finalRoleCode = roleCode;
        Iterator<Role> cutsIterator = custRoles.iterator();
        while (cutsIterator.hasNext()) {
//            如果下级角色赋予上级角色权限
            if (finalRoleCode.contains(cutsIterator.next().getRoleCode())) {
                return ResultBean.getInstance("500", "对方已拥有该角色");
            }
        }
        UserRole save = userRoleRepository.save(userRole);
        log.info("分配角色："+ userRole.toString());
        return ResultBean.getInstance(save);
    }

    // 拥有某些特殊角色的人才能新添角色
    @Transactional
    public ResultBean insertRole(Role role) {

        String roleCode = role.getRoleCode();
        List<String> roleCodes = UserInfoService.getRoleCodes();
        AtomicBoolean agree = new AtomicBoolean(false);
        roleCodes.forEach(code -> {
            if (roleCode.contains(code)) {
                String[] lowSplit = roleCode.split(":");
                String[] heightSplit = code.split(":");
                if (heightSplit.length < lowSplit.length && heightSplit.length < 4) {
                    agree.set(true);
                }
            }
        });
        Set<PoseidonGrantedAuthority> grantedAuthority = role.getAuthorities();
        Set<PoseidonGrantedAuthority> authorities = UserInfoService.getUser().getAuthorities();
        Iterator<PoseidonGrantedAuthority> iterator = grantedAuthority.iterator();
        boolean isLegal=true;
        List<RoleGranted> roleGranteds=new ArrayList<>();
        while (iterator.hasNext()){
            PoseidonGrantedAuthority next = iterator.next();
            if (!authorities.contains(next)){
               isLegal=false;
              break;
           }
            RoleGranted roleGranted = new RoleGranted();
           roleGranted.setGrantedId(next.getId());
            roleGranteds.add(roleGranted);
        }
        if (!isLegal){
            return ResultBean.getInstance("500", "无权限添加");
        }
        if (agree.get()) {
            role.setCreateTime(new Date()).setCreateId(UserInfoService.getUser().getId());
            try {
                Role save = poseidonRoleRepository.save(role);
                roleGranteds.forEach(roleGranted -> {
                    roleGranted.setRoleId(save.getId());
                });
                log.info("创建角色："+save.toString());
                roleGrantedRepository.saveAll(roleGranteds);
                return ResultBean.getInstance(role);
            } catch (Exception e) {
                throw new PoseidonException("角色码已存在","500");
            }
        }
        return ResultBean.getInstance("500", "无权限添加");
    }
    @Transactional
    public ResultBean update(Role role) {
        if (role.getId()==null){
            return ResultBean.getInstance("500","数据异常");
        }
        List<String> roleCodes = UserInfoService.getRoleCodes();
        AtomicBoolean agree = new AtomicBoolean(false);
        roleCodes.forEach(rolecode->{
             int length = rolecode.split(":").length;
            if (rolecode.equals(role.getRoleCode())&&length<4){
                poseidonRoleRepository.save(role);
                log.info("更新角色："+ role.toString());
                agree.set(true);
            }
        });
        if (agree.get()){

            return ResultBean.getInstance();
        }
        return ResultBean.getInstance("500","更新失败，无权限");
    }

    public ResultBean delete(String id) {

        return null;
    }
}
