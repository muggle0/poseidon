package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.repos.PoseidonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    PoseidonRoleRepository poseidonRoleRepository;

    public ResultBean setRole(Role role) {
        Role save = poseidonRoleRepository.save(role);
        ResultBean resultBean = new ResultBean();
        resultBean.success("插入成功",role);
        return resultBean;
    }
}
