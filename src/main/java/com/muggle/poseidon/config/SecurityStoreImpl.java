package com.muggle.poseidon.config;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.mapper.OaUserInfoMapper;
import com.muggle.poseidon.store.SecurityStore;
import org.redisson.api.RBucket;
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
    OaUserInfoMapper userInfoMapper;


    @Override
    public UserDetails getUserdetail(String key) throws BasePoseidonCheckException {
        RBucket<UserDetails> bucket = redissonClient.getBucket(key);
        UserDetails userDetails = bucket.get();
        if (userDetails==null){
            throw new SimplePoseidonCheckException("用户未登陆");
        }

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
