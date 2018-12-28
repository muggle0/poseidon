package com.muggle.poseidon.core.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: poseidon
 * @description: 403处理器
 * @author: muggle
 * @create: 2018-12-27 19:21
 **/

public class PoseidonAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print("无权限");
    }
}
