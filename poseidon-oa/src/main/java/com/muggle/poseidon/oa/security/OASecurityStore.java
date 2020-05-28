package com.muggle.poseidon.oa.security;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.store.SecurityStore;
import com.muggle.poseidon.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/4/16
 **/
@Service
public class OASecurityStore implements SecurityStore {
    @Value("${oa.key}")
    private String key;
    @Override
    public UserDetails getUserdetail(String s) throws BasePoseidonCheckException {
        return null;
    }

    @Override
    public String signUserMessage(UserDetails userDetails) {
        Assert.isTrue(userDetails.isEnabled(),"账号已注销");
        Assert.isTrue(userDetails.isAccountNonLocked(),"账号已锁定，联系管理员解锁");
        Assert.isTrue(userDetails.isEnabled(),"账号已经过期，联系管理员获得权限");
        HashMap<String, Object> param = new HashMap<>();
        param.put("role","admin");
        param.put("VERSION", UUID.randomUUID().toString());
        String token = JwtTokenUtils.createToken(param, key, 12L);
        return token;
    }

    @Override
    public Boolean cleanToken(String s) {
        return null;
    }
}
