package com.muggle.poseidon.oa.controller;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.util.UserInfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/26
 **/
@Controller
public class ViewController {
    private static final Logger log = LoggerFactory.getLogger(ViewController.class);

    @GetMapping("/")
    public String index() {
        try {
            if (UserInfoUtils.getUserInfo() != null) {
                return "redirect:/pear/index.html";
            }
        } catch (BasePoseidonCheckException e) {
            log.error("首页获取用户信息错误");
            return "view/error/500.html";
        }
        return "redirect:/pear/login.html";
    }


    /**/
}
