package com.muggle.poseidon.service.helper.impl;

import java.util.ArrayList;
import java.util.List;

import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.entity.OaUserInfo;
import com.muggle.poseidon.mapper.OaRoleMapper;
import com.muggle.poseidon.service.helper.LoginHelper;
import com.muggle.poseidon.service.manager.UserInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private OaRoleMapper oaRoleMapper;
    @Override
    public UserDetails login(String username, String password) throws SimplePoseidonCheckException {
        OaUserInfo userInfo= ((OaUserInfo) userInfoManager.loadUserByUsername(username));
        // fixme
        boolean matches = passwordEncoder.matches(password, userInfo.getPassword());
        if (!matches){
            throw new SimplePoseidonCheckException("密码错误");
        }
        List<String>roles= oaRoleMapper.selectCodeByUserId(userInfo.getId());
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        roles.forEach(role->{
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        });
        userInfo.setAuthorities(authorities);
        return userInfo;
    }
}
