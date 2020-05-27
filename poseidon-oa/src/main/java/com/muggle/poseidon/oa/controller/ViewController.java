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
    public String index(HttpServletResponse response){
        try {
            if (UserInfoUtils.getUserInfo()!=null){
                response.sendRedirect("http://localhost:8080/views/index.html");
            }
        } catch (BasePoseidonCheckException e) {
           log.error("获取用户信息异常",e);
        } catch (IOException e) {
            return "template/tips/error.html";
        }
        return "user/login.html";
    }


/**/
}
