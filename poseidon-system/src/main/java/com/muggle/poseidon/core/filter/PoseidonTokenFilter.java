package com.muggle.poseidon.core.filter;

import com.muggle.poseidon.core.exception.BadTokenException;
import com.muggle.poseidon.core.properties.SecurityProperties;
import com.muggle.poseidon.core.properties.TokenProperties;
import com.muggle.poseidon.model.MessagePrincipal;
import com.muggle.poseidon.service.RedisService;
import com.muggle.poseidon.service.impl.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: poseidon
 * @description: Token过滤器 框架有一个AbstractAuthenticationProcessingFilter
 * 默认实现类UsernamePasswordAuthenticationFilter 我们的目的是将自定义的实现类替换掉它
 * @author: muggle
 * @create: 2018-12-22 12:04
 **/
@Slf4j
//@Component
public class PoseidonTokenFilter extends UsernamePasswordAuthenticationFilter {

    /*    @Value("${token.header}")
        private String tokenHeader;
        @Value("${token.name}")
        private String tokenName;*/
    private RedisService redisService;

    public PoseidonTokenFilter(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String method = request.getMethod();
        if (!request.getMethod().equalsIgnoreCase("POST")) {
            throw new AuthenticationServiceException("请求非法 ");
        }
//        从form-data中把值拿出来

        String username = this.obtainUsername(request);
        String password = this.obtainPassword(request);
        if (username == null) {
            throw new AuthenticationServiceException("用户名为空");
        }
        String isMessage = request.getParameter(TokenProperties.IS_MESSAGE);
        if (password == null) {
            password = "";
        }
        if(isMessage==null){
            isMessage="other";
        }
        username = username.trim();
        String verification = request.getParameter(TokenProperties.VERIFICATION);
        String key=TokenProperties.VERIFICATION + "-" + username;
        String access = redisService.get(key);
        if (verification == null || !verification.equalsIgnoreCase(access)) {
            throw new AuthenticationServiceException("验证码错误或过期");
        }

        logger.info("username:" + username);
        logger.info("password:" + password);
        UsernamePasswordAuthenticationToken authRequest = null;
//        这里本来想弄个短信登录，但由于经费问题只搞了个email登录，所以命名略显不协调
        switch (isMessage){
            case "phone":
                MessagePrincipal message = new MessagePrincipal();
                message.setCode(TokenProperties.MESSAGE_CODE);
                message.setPrincipal(username);
                authRequest = new UsernamePasswordAuthenticationToken(message, password);
                break;
            case "email":
                MessagePrincipal email = new MessagePrincipal();
                email.setCode(TokenProperties.EMAIL_CODE);
                email.setPrincipal(username);
                authRequest = new UsernamePasswordAuthenticationToken(email, password);
                break;
            default:
                authRequest = new UsernamePasswordAuthenticationToken(username, password);
        }
        setDetails(request, authRequest);

        Authentication authenticate = null;
//            执行过程 filter---AuthenticationProvider--successHander
        authenticate = this.getAuthenticationManager().authenticate(authRequest);
        redisService.delete(key);
        return authenticate;
    }

}
