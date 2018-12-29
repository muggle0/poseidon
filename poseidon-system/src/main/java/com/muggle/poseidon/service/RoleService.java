package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResoultBean;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.repos.PoseidonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    PoseidonRoleRepository poseidonRoleRepository;

    public ResoultBean setRole(Role role) {
        Role save = poseidonRoleRepository.save(role);
        ResoultBean resoultBean = new ResoultBean();
        resoultBean.success("插入成功",role);
        return resoultBean;
    }
}
