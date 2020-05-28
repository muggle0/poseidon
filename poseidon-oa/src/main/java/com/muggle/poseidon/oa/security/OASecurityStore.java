package com.muggle.poseidon.oa.security;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.store.SecurityStore;
import com.muggle.poseidon.util.JwtTokenUtils;
import com.muggle.poseidon.util.RSACoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;

import static com.muggle.poseidon.util.JwtTokenUtils.createToken;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/4/16
 **/
@Service
public class OASecurityStore implements SecurityStore {

    private static final Logger log = LoggerFactory.getLogger(OASecurityStore.class);
    private PathMatcher pathMatcher = new AntPathMatcher();
    @Value("${oa.key}")
    private String credential;


    @Override
    public UserDetails getUserdetail(String token) throws BasePoseidonCheckException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String requestURI = attributes.getRequest().getRequestURI();
        boolean match = pathMatcher.match("/pear/**", requestURI);
        if (match) {
            return null;
        }
        token
    }

    @Override
    public String signUserMessage(UserDetails userDetails) {
        Map<String, Object> body = new HashMap<>();
        body.put("username", userDetails.getUsername());
        body.put("version", UUID.randomUUID().toString());
        body.put("roles", Arrays.asList("admin", "guest"));
        String token = createToken(body, "test");
        return token;

    }

    @Override
    public Boolean cleanToken(String s) {
        return null;
    }
}
