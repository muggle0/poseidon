package com.muggle.poseidon.oa.controller;

import com.alibaba.fastjson.JSON;
import com.muggle.code.SimpleCodeTemplate;
import com.muggle.code.TableMessage;
import com.muggle.poseidon.annotation.InterfaceAction;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;
import com.muggle.poseidon.service.oa.IOaUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/21
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IOaUserInfoService userInfoService;


    @PostMapping("/regester.json")
    public ResultBean<OaUserInfo> regester(@RequestBody @Valid OaUserVO userVO){
        OaUserInfo oaUserInfo=userInfoService.regester(userVO);
        return ResultBean.successData(oaUserInfo);
    }

    @GetMapping("/info.json")// fixme 加入权限控制 登录用户
    public ResultBean<OaUserInfo> getUserInfo(@NotNull(message = "请输入用户名") String username){
        OaUserInfo userInfo = userInfoService.getUserInfo(username);
        return ResultBean.successData(userInfo);
    }



    public static void main(String[] args) {
        TableMessage tableMessage = new TableMessage();
        tableMessage.setUsername("root");
        tableMessage.setSwagger(true);
        tableMessage.setTableName(Arrays.asList("oa_role"));
        tableMessage.setAuthor("muggle");
        tableMessage.setBasePack("com.muggle.poseidon");
        tableMessage.setDriver("com.mysql.jdbc.Driver");
        tableMessage.setJdbcUrl("jdbc:mysql:///p_oa?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        tableMessage.setModule("poseidon");
        tableMessage.setPassword("root");
        tableMessage.setSwagger(true);
        SimpleCodeTemplate simpleCodeTemplate = new SimpleCodeTemplate(tableMessage);
        simpleCodeTemplate.createCode();
    }
}
