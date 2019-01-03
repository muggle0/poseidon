package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.model.UserRole;
import com.muggle.poseidon.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/1
 * @description：权限相关接口
 * @version: 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;

    @GetMapping("/find")
    public ResultBean getRoles(){
        return roleService.getRoles();
    }

    @GetMapping("/find/{id}")
    public ResultBean getRoleByd(@PathVariable("id") String id){
        return roleService.findOne(id);
    }
    @PostMapping("/insert/user_role")
    public ResultBean insertUserRole(UserRole userRole){
        return roleService.insertUserRole(userRole);
    }

    @PostMapping("/insert/role")
    public ResultBean insertRole(Role role){
        return roleService.insertRole(role);
    }
}
