package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.vo.VerifVO;
import com.muggle.poseidon.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/public/hello")
    public String get(){
        return "你好啊";
    }

    //    初始化数据库 生成一个超级管理员超级
    @GetMapping("/public/wer34retrty-asdfwsdfsd.html")
    @ResponseBody
    public ResultBean create(){
        return oauthService.create();
    }

    /**
     * description: 获取验证码
     *
     */
    @PostMapping("/public/verification")
    @ResponseBody
    public ResultBean getVerification(@RequestBody @Validated VerifVO verifVO){
        return oauthService.getVerification(verifVO);
    }

    /**
     * description: 测试
     *
     */
    @PostMapping ("/admin/role")
    @ResponseBody
    public ResultBean setRole(@RequestBody @Validated PoseidonUserDetail poseidonUserDetail){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
//        todo 权限
        return ResultBean.getInstance();
    }

}
