package com.muggle.poseidon.core.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: poseidon
 * @description: 认证成功处理器
 * @author: muggle
 * @create: 2018-12-27 19:07
 **/
@Component
public class PoseidonAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print("登录成功");
        outputStream.close();
    }
}
