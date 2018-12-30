package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import com.muggle.poseidon.service.PoseidonUserdetailsService;
import com.muggle.poseidon.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/test/role")
    @ResponseBody
    public ResultBean setRole(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Role role = new Role();
        role.setEnable(true).setRoleCode("admin").setName("超级管理员").setSort(1);
        final ResultBean resultBean = roleService.setRole(role);
        return resultBean;
    }
    @GetMapping("/public/test")
    @ResponseBody
    public ResultBean getUserdetail(PoseidonUserDetail userDetails){//一个这么小小的毛病踩了一下午坑，不知道当时怎么想的
        throw new NullPointerException();
       /* System.out.println("sssssssssssssssssssss");
        UserDetails test = poseidonUserdetailsService.loadUserByUsername("w");
        ResultBean resultBean=new ResultBean();
        resultBean.setDate(test).setMsg("成功").setCode("200");
        return resultBean;*/
    }
}
