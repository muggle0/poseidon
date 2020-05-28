package com.muggle.poseidon.oa.security;

import com.alibaba.fastjson.JSONObject;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.AuthUrlPathDO;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.service.TokenService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/4/16
 **/

@Service
public class OATokenServiceImpl implements TokenService {
    @Override
    public UserDetails getUserById(Long aLong) {
        return null;
    }

    @Override
    public boolean rooleMatch(Collection<? extends GrantedAuthority> collection, String s) {
        return false;
    }

    @Override
    public void saveUrlInfo(List<AuthUrlPathDO> list) {

    }

    @Override
    public UserDetails login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SimplePoseidonCheckException {
        String method = httpServletRequest.getMethod();
        try {
            BufferedReader reader = httpServletRequest.getReader();
            OaUserInfo oaUserInfo = JSONObject.parseObject(reader.readLine(), OaUserInfo.class);
            reader.close();
        } catch (IOException e) {
            throw new SimplePoseidonCheckException("登录异常");
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
