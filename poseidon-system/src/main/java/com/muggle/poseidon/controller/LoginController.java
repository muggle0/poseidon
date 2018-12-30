package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.service.PoseidonUserdetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    PoseidonUserdetailsService poseidonUserdetailsService;
    @GetMapping("/login_page")
    public String getLogin(){
        log.info("请求登录页面");
        return "/resources/login.html";
    }

    @PostMapping("/sign_up")
    @ResponseBody
    public ResultBean toSignUp(@Validated PoseidonUserDetail userDetail){
        ResultBean resultBean = poseidonUserdetailsService.toSignUp(userDetail);
        return resultBean;
    }
    @GetMapping("/sign_page")
    public String signPage(){
        return "/resources/sign.html";
    }
}
