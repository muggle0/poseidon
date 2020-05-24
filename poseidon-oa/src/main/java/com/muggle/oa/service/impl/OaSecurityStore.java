package com.muggle.oa.service.impl;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.store.SecurityStore;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/24
 **/
public class OaSecurityStore implements SecurityStore {
    @Override
    public UserDetails getUserdetail(String s) throws BasePoseidonCheckException {
        return null;
    }

    @Override
    public String signUserMessage(UserDetails userDetails) {
        return null;
    }

    @Override
    public Boolean cleanToken(String s) {
        return null;
    }
}
