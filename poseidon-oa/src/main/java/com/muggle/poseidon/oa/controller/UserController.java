package com.muggle.poseidon.oa.controller;

import com.alibaba.fastjson.JSON;
import com.muggle.code.SimpleCodeTemplate;
import com.muggle.code.TableMessage;
import com.muggle.poseidon.annotation.InterfaceAction;
import com.muggle.poseidon.base.OAException;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;
import com.muggle.poseidon.service.oa.IOaUserInfoService;
import com.muggle.poseidon.util.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
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
//@Validated
public class UserController {

   /* @Autowired
    Validator validator;*/
    @Autowired
    IOaUserInfoService userInfoService;


    @PostMapping("/regester.json")
    public ResultBean<OaUserInfo> regester(@RequestBody @Valid OaUserVO userVO){
        OaUserInfo oaUserInfo=userInfoService.regester(userVO);
        return ResultBean.successData(oaUserInfo);
    }

    @GetMapping("/info")
    public ResultBean<OaUserInfo> getUserInfo( String username){
        OaUserInfo userInfo = userInfoService.getUserInfo(username);
        return ResultBean.successData(userInfo);
    }


    @GetMapping("my_info")
    public ResultBean<OaUserInfo> getMyUserInfo() throws BasePoseidonCheckException {
        UserDetails userDetails = UserInfoUtils.getUserInfo();
        if (userDetails==null){
            throw new OAException("用户未登录");
        }
        OaUserInfo userInfo = userInfoService.getUserInfo(userDetails.getUsername());
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
