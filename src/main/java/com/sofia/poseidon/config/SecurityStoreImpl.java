package com.sofia.poseidon.config;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.mapper.SysUserMapper;
import com.muggle.poseidon.store.SecurityStore;
import com.sofia.poseidon.tool.UserInfoTool;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@Component
@Order(1)
@Slf4j
public class SecurityStoreImpl implements SecurityStore {
    @Autowired
    RedissonClient redissonClient;
    @Autowired
    SysUserMapper userInfoMapper;

    public SecurityStoreImpl() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>> SecurityStoreImpl 初始化 <<<<<<<<<<<<<<<<<<<<<");
        SecurityStore.saveAccessPath(Arrays.asList("/auth/api/captcha","/**/*.json"));
    }

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
