package com.muggle.poseidon.core.filter;

import com.muggle.poseidon.core.exception.BadTokenException;
import com.muggle.poseidon.core.exception.PoseidonSystemException;
import com.muggle.poseidon.core.properties.TokenProperties;
import com.muggle.poseidon.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: poseidon
 * @description: Token过滤器 框架有一个AbstractAuthenticationProcessingFilter
 *                 默认实现类UsernamePasswordAuthenticationFilter 我们的目的是将自定义的实现类替换掉它
 * @author: muggle
 * @create: 2018-12-22 12:04
 **/
@Slf4j
@Component
public class PoseidonTokenFilter extends UsernamePasswordAuthenticationFilter {

/*    @Value("${token.header}")
    private String tokenHeader;
    @Value("${token.name}")
    private String tokenName;*/
    @Autowired
    private RedisService redisService;
//    public PoseidonTokenFilter() {
//        super.setFilterProcessesUrl("/auth_login");
//    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equalsIgnoreCase("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
//        从form-data中把值拿出来


        String username = this.obtainUsername(request);
        String password = this.obtainPassword(request);
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();
        String verification = request.getParameter("verification");
        final String s = redisService.get(username);
        if (verification==null){
            throw new PoseidonSystemException("验证码错误",500);
        }
        logger.info("username:"+username);
        logger.info("password:"+password);

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        Authentication authenticate = null;
        try{
//            执行过程 filter---AuthenticationProvider--successHander
            authenticate = this.getAuthenticationManager().authenticate(authRequest);
        }catch (BadCredentialsException e){
            throw new BadTokenException(TokenProperties.BAD_TOKEN_MSG,TokenProperties.BAD_TOKEN_CODE);
        }
        return authenticate;
    }

}
