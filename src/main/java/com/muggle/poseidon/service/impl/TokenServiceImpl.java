package com.muggle.poseidon.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.AuthUrlPathDO;
import com.muggle.poseidon.service.TokenService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
public class TokenServiceImpl implements TokenService {
    @Override
    public UserDetails getUserById(Long aLong) {
        return null;
    }

    @Override
    public boolean rooleMatch(Collection<? extends GrantedAuthority> collection, String s) {
        return false;
    }

    @Override
    public void processUrl(List<AuthUrlPathDO> list) {

    }

    @Override
    public UserDetails login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SimplePoseidonCheckException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
