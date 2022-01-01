package com.muggle.poseidon.helper.impl;

import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.pojo.SysUser;
import com.muggle.poseidon.helper.LoginHelper;
import com.muggle.poseidon.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/12
 **/
@Service("normalLoginHelper")
public class NormalLoginHelper implements LoginHelper {
    @Autowired
    UserInfoManager userInfoManager;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails login(String username, String password) throws SimplePoseidonCheckException {
        SysUser userInfo= ((SysUser) userInfoManager.loadUserByUsername(username));
        if (userInfo==null){
            throw new SimplePoseidonCheckException("用户信息不存在");
        }
        boolean matches = passwordEncoder.matches(password, userInfo.getPassword());
        if (!matches){
            throw new SimplePoseidonCheckException("密码错误");
        }
        final String permissionCodes = userInfoManager.getPermissionByUserId(userInfo.getId());
        userInfo.setRoleCodes(permissionCodes);
        return userInfo;
    }
}
