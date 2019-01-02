package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/1
 * @description：权限相关接口
 * @version: 1.0
 */
@RestController
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;
    @GetMapping
    public ResultBean getRoles(){
        return roleService.getRoles();
    }
}
