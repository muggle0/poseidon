package com.muggle.poseidon.core.handler;

import com.muggle.poseidon.entity.PoseidonUserDetail;
import com.muggle.poseidon.manager.UserInfoManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: poseidon
 * @description: 认证成功处理器
 * @author: muggle
 * @create: 2018-12-27 19:07
 **/
public class PoseidonAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final static Logger log = LoggerFactory.getLogger("requestLog");
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        PoseidonUserDetail details = (PoseidonUserDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
        log.info("用户登录 id：{}", details.getId());
        response.setContentType("application/json;charset=UTF-8");
        final PrintWriter writer = response.getWriter();
        writer.write("{\"code\":\"200\",\"msg\":\"登录成功\"}");
        writer.close();
    }
}
