package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;


/**
 * @program: poseidon
 * @description: redis客户端封装，不直接使用redisTemplate是方便未来替换redisTemplate
 * @author: muggle
 * @create: 2018-12-21 16:50
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    public RedisTemplate<Object,Object> getInstance(){
        return redisTemplate;
    }

    /**
     * 设置 String 类型 key-value
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }


    /**
     * 获取 String 类型 key-value
     * @param key
     * @return
     */
    @Override
    public String get(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置 String 类型 key-value 并添加过期时间 (毫秒单位)
     * @param key
     * @param value
     * @param time 过期时间,毫秒单位
     */
    @Override
    public void setForTimeMS(String key, String value, long time){
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);
    }

    /**
     * 设置 String 类型 key-value 并添加过期时间 (分钟单位)
     * @param key
     * @param value
     * @param time 过期时间,分钟单位
     */
    @Override
    public void setForTimeMIN(String key, String value, long time){
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
    }

    /**
     * 设置 String 类型 key-value 并添加过期时间 (分钟单位)
     * @param key
     * @param value
     * @param time 过期时间,分钟单位
     */
    @Override
    public void setForTimeCustom(String key, String value, long time, TimeUnit type){
        redisTemplate.opsForValue().set(key, value, time, type);
    }

    /**
     * 如果 key 存在则覆盖,并返回旧值.
     * 如果不存在,返回null 并添加
     * @param key
     * @param value
     * @return
     */
    @Override
    public String getAndSet(String key, String value){
        return (String) redisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 给一个指定的 key 值附加过期时间
     * @param key
     * @param time
     * @param type
     * @return
     */
    @Override
    public boolean expire(String key, long time, TimeUnit type){
        return redisTemplate.boundValueOps(key).expire(time, type);
    }

    /**
     * 移除指定key 的过期时间
     * @param key
     * @return
     */
    @Override
    public boolean persist(String key){
        return redisTemplate.boundValueOps(key).persist();
    }


    /**
     * 获取指定key 的过期时间
     * @param key
     * @return
     */
    @Override
    public Long getExpire(String key){
        return redisTemplate.boundValueOps(key).getExpire();
    }

    /**
     * 修改 key
     * @param key
     * @return
     */
    @Override
    public void rename(String key, String newKey){
        redisTemplate.boundValueOps(key).rename(newKey);
    }

    /**
     * 删除 key-value
     * @param key
     * @return
     */
    @Override
    public boolean delete(String key){
        return redisTemplate.delete(key);
    }


}




