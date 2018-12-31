package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.service.impl.PoseidonUserdetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    PoseidonUserdetailsServiceImpl poseidonUserdetailsService;

    /**
     * description: 登录请求视图接口
     *
     */
    @GetMapping("/login_page")
    public String getLogin(){
        log.info("请求登录页面");
        return "/resources/login.html";
    }

    /**
     * description: 注册
     */
    @PostMapping("/sign_up")
    @ResponseBody
    public ResultBean toSignUp(@Validated PoseidonUserDetail userDetail,@NotNull String verification){
        ResultBean resultBean = poseidonUserdetailsService.toSignUp(userDetail, verification);
        return resultBean;
    }

    /**
     * description: 注册页
     *
     */
    @GetMapping("/sign_page")
    public String signPage(){
        return "/resources/sign.html";
    }




}
