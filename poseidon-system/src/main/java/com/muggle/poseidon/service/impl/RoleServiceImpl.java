package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.model.UserRole;
import com.muggle.poseidon.model.vo.RoleVO;
import com.muggle.poseidon.repos.PoseidonRoleRepository;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
import com.muggle.poseidon.repos.UserRoleRepository;
import com.muggle.poseidon.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class RoleServiceImpl {
    @Autowired
    PoseidonRoleRepository poseidonRoleRepository;
    @Autowired
    PoseidonUserDetailsRepository userDetailsRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    public ResultBean setRole(Role role) {
        Role save = poseidonRoleRepository.save(role);
        ResultBean resultBean = new ResultBean();
        resultBean.success("插入成功", role);
        return resultBean;
    }

    @Transactional
    public List<Role> findAll(Role role) {
        final List<Role> all = poseidonRoleRepository.findAll((root, query, builder) -> {
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
        final Optional<Role> byId = poseidonRoleRepository.findById(id);
        return ResultBean.getInstance(byId.get());
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
        return ResultBean.getInstance(save);
    }

    // 拥有某些特殊角色的人才能新添角色
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
        if (agree.get()) {
            role.setCreateTime(new Date()).setCreateId(UserInfoService.getUser().getId());
            poseidonRoleRepository.save(role);
            return ResultBean.getInstance(role);
        }
        return ResultBean.getInstance("500", "无权限添加");
    }

    public ResultBean update(Role role) {
        List<String> roleCodes = UserInfoService.getRoleCodes();
        AtomicBoolean agree = new AtomicBoolean(false);
        roleCodes.forEach(rolecode->{
             int length = rolecode.split(":").length;
            if (rolecode.equals(role.getRoleCode())&&length<4){
                poseidonRoleRepository.save(role);
                agree.set(true);
            }
        });
        if (agree.get()){
            return ResultBean.getInstance();
        }
        return ResultBean.getInstance("500","更新失败，无权限");
    }
}
