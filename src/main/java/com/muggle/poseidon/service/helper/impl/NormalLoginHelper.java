package com.muggle.poseidon.service.helper.impl;

import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.OaUserInfo;
import com.muggle.poseidon.service.helper.LoginHelper;
import com.muggle.poseidon.service.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/12
 **/
@Service("normalLoginHelper")
public class NormalLoginHelper implements LoginHelper {
    @Autowired
    UserInfoManager userInfoManager;
    @Override
    public UserDetails login(String username, String password) throws SimplePoseidonCheckException {
        OaUserInfo userInfo=userInfoManager.login(username,password);
        return null;
    }
}
