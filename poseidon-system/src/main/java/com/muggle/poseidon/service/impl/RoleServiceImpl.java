package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.model.UserRole;
import com.muggle.poseidon.model.vo.RoleVO;
import com.muggle.poseidon.repos.PoseidonRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl {
    @Autowired
    PoseidonRoleRepository poseidonRoleRepository;
   /* @Autowired
    User*/

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

    public ResultBean insertUserRole(UserRole userRole) {
        PoseidonUserDetail details = (PoseidonUserDetail)SecurityContextHolder.getContext().getAuthentication().getDetails();
        Set<Role> roles = details.getRoles();

        return null;
    }
}
