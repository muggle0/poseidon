package com.muggle.poseidon.core.handler;

import com.muggle.poseidon.manager.UserInfoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * @program: poseidon
 * @description: 登出成功处理器
 * @author: muggle
 * @create: 2018-12-31
 **/
public class PoseidonLogoutSuccessHandler implements LogoutSuccessHandler {
    private final static Logger log = LoggerFactory.getLogger("requestLog");
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        final PrintWriter writer = response.getWriter();
        log.info("用户登出");
        writer.write("{\"code\":\"200\",\"msg\":\"登出成功\"}");
        writer.close();
    }
}
