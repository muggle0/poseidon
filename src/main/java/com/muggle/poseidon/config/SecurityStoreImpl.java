package com.muggle.poseidon.config;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.store.SecurityStore;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
public class SecurityStoreImpl implements SecurityStore {
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
