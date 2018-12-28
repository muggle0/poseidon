package com.muggle.poseidon.controller;

import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.service.PoseidonUserdetailsService;
import com.muggle.poseidon.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: poseidon
 * @description: 测试reids
 * @author: muggle
 * @create: 2018-12-21 17:06
 **/
@RestController
public class TestController {
    @Autowired
    PoseidonUserdetailsService poseidonUserdetailsService;

    @GetMapping("/login_page")
    public String getLogin(){
        System.out.println("test");
        return "/static/login.html";
    }

    @GetMapping("/sign_in")
    public String toSignIn(PoseidonUserDetail userDetail){
        poseidonUserdetailsService.toSignIn(userDetail);
        return "ss";
    }
}
