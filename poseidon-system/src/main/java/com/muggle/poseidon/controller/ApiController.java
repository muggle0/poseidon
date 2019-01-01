package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-28 17:52
 **/
@RestController
public class ApiController {
    @Autowired
    OauthService oauthService;


    @GetMapping("/hello")
    public String get(){
        return "你好啊";
    }

    //    初始化数据库 生成一个超级管理员超级
    @GetMapping("/public/wer34retrty-asdfwsdfsd")
    @ResponseBody
    public ResultBean create(){
        return oauthService.create();
    }

    /**
     * description: 获取验证码
     *
     */
    @GetMapping("/public/verification")
    @ResponseBody
    public ResultBean getVerification(@Validated PoseidonUserDetail poseidonUserDetail){
        return oauthService.getVerification(poseidonUserDetail);
    }

    /**
     * description: 测试
     *
     */
    @GetMapping("/admin/role")
    @ResponseBody
    public ResultBean setRole(@Validated PoseidonUserDetail poseidonUserDetail){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        return ResultBean.getInstance();
    }
}
