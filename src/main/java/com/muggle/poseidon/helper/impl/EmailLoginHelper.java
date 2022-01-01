package com.muggle.poseidon.helper.impl;

import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.helper.LoginHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/12
 **/
@Service("otherLoginHelper")
public class EmailLoginHelper implements LoginHelper {
    @Override
    public UserDetails login(String username, String password) throws SimplePoseidonCheckException {
        return null;
    }
}
