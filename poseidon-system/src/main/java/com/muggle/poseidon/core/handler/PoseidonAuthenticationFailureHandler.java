package com.muggle.poseidon.core.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: poseidon
 * @description: 认证失败处理器
 * @author: muggle
 * @create: 2018-12-27 19:08
 **/
public class PoseidonAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        final PrintWriter writer = response.getWriter();
        if(exception.getMessage().equals("坏的凭证")){
            writer.write("{\"code\":\"401\",\"msg\":\"登录失败,用户名或者密码有误\"}");
            writer.close();
        }else {
            writer.write("{\"code\":\"401\",\"msg\":\"登录失败,"+exception.getMessage()+"\"}");
            writer.close();
        }

    }
}
