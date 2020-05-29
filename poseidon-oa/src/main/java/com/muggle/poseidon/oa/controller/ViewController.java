package com.muggle.poseidon.oa.controller;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.util.UserInfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/26
 **/
@Controller
public class ViewController {
    @Value("${oa.key}")
    private String credential;
    private static final Logger log = LoggerFactory.getLogger(ViewController.class);

    @GetMapping("/")
    public String login() {
        try {
            if (UserInfoUtils.getUserInfo() != null) {
                return "index.html";
            }
        } catch (BasePoseidonCheckException e) {
            log.error("首页获取用户信息错误");
            return "view/error/500.html";
        }
        return "login.html";
    }


}
