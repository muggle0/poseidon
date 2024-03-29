package com.sofia.poseidon.config;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.manager.UserInfoManager;
import com.sofia.poseidon.mapper.SysUserMapper;
import com.muggle.poseidon.store.SecurityStore;
import com.sofia.poseidon.tool.UserInfoTool;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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
    private RedissonClient redissonClient;
    @Autowired
    private SysUserMapper userInfoMapper;
    @Autowired
    private UserInfoManager userInfoManager;

    public SecurityStoreImpl() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>> SecurityStoreImpl 初始化 <<<<<<<<<<<<<<<<<<<<<");
        SecurityStore.saveAccessPath(Arrays.asList("/auth/api/captcha","/**/*.json"));
    }

    @Override
    public UserDetails getUserdetail(String token) throws BasePoseidonCheckException {
        final String id = UserInfoTool.parserToken(token);
        final RMapCache<Object, Object> mapCache = redissonClient.getMapCache("poseidon:user:token");
        final Object userInfo = mapCache.get(Long.valueOf(id));
        return ((UserDetails) userInfo);
    }

    @Override
    public String signUserMessage(UserDetails userDetails) {
        String token = UserInfoTool.creakeToken((SysUser) userDetails);
        final SysUser sysUser = (SysUser) userDetails;
        final RMapCache<Object, Object> users = redissonClient.getMapCache("poseidon:user:token");
        users.put(sysUser.getId(),sysUser,10, TimeUnit.HOURS);
        return token;
    }

    @Override
    public Boolean cleanToken(String username) {
        SysUser sysUser = (SysUser) userInfoManager.loadUserByUsername(username);
        if (sysUser==null){
            return true;
        }
        redissonClient.getMapCache("poseidon:user:token").remove(sysUser.getId());
        return true;
    }}
