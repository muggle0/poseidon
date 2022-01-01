package com.muggle.poseidon.config;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.entity.pojo.SysUser;
import com.muggle.poseidon.mapper.SysUserMapper;
import com.muggle.poseidon.store.SecurityStore;
import com.muggle.poseidon.tool.UserInfoTool;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@Component
public class SecurityStoreImpl implements SecurityStore {
    @Autowired
    RedissonClient redissonClient;
    @Autowired
    SysUserMapper userInfoMapper;


    @Override
    public UserDetails getUserdetail(String token) throws BasePoseidonCheckException {
        SysUser userInfo= UserInfoTool.parserToken(token);
        return userInfo;
    }

    @Override
    public String signUserMessage(UserDetails userDetails) {
        String s = UserInfoTool.creakeToken((SysUser) userDetails);
        return s;
    }

    @Override
    public Boolean cleanToken(String username) {
        return true;
    }
}
