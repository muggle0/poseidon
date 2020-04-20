package com.muggle.poseidon.security;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.store.SecurityStore;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/4/16
 **/
@Service
public class OASecurityStore implements SecurityStore {
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
