package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResoultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.service.PoseidonUserdetailsService;
import com.muggle.poseidon.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: poseidon
 * @description: 测试reids
 * @author: muggle
 * @create: 2018-12-21 17:06
 **/
@Controller
@Slf4j
public class TestController {
    @Autowired
    PoseidonUserdetailsService poseidonUserdetailsService;
    @Autowired
    RoleService roleService;

    @GetMapping("/login_page")
    public String getLogin(){
        log.info("请求登录页面");
        return "/resources/login.html";
    }

    @GetMapping("/sign_up")
    @ResponseBody
    public String toSignIn(PoseidonUserDetail userDetail){
        poseidonUserdetailsService.toSignIn(userDetail);
        return "ss";
    }
    @Secured("ROLE_TELLER")
    @GetMapping("/test/role")
    @ResponseBody
    public ResoultBean setRole(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Role role = new Role();
        role.setEnable(true).setRoleCode("admin").setName("超级管理员").setSort(1);
        final ResoultBean resoultBean = roleService.setRole(role);
        return resoultBean;
    }
}
