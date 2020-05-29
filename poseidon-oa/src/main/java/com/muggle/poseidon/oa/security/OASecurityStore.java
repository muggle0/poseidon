package com.muggle.poseidon.oa.security;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.entity.oa.OaRole;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.oa.mapper.OaRoleMapper;
import com.muggle.poseidon.store.SecurityStore;
import com.muggle.poseidon.util.JwtTokenUtils;
import com.muggle.poseidon.util.RSACoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    OaRoleMapper roleMapper;


    private static final Logger log = LoggerFactory.getLogger(OASecurityStore.class);
    private PathMatcher pathMatcher = new AntPathMatcher();

    @Value("${oa.key}")
    private String credential;

    @Override
    public UserDetails getUserdetail(String token) throws BasePoseidonCheckException {
        UserDetails userDetails = OaUserInfoTool.covertToken(token, credential);
        return userDetails;
    }

    @Override
    public String signUserMessage(UserDetails userDetails) {
        Assert.isTrue(userDetails.isEnabled(),"账号已注销");
        Assert.isTrue(userDetails.isAccountNonExpired(),"账号已过期");
        Assert.isTrue(userDetails.isAccountNonLocked(),"账号被锁定");
        List<OaRole> roles=roleMapper.selectByUsername(userDetails.getUsername());
        List<String> roleCodes=new ArrayList<>();
        for (OaRole role : roles) {
            roleCodes.add(role.getRoleCode());
        }
        Map<String, Object> body = new HashMap<>();
        // fixme
        body.put("username", userDetails.getUsername());
        body.put("version",System.currentTimeMillis());
        body.put("roles", roleCodes);
        String token = createToken(body, credential);

        return token;
    }

    @Override
    public Boolean cleanToken(String s) {
        return null;
    }
}
