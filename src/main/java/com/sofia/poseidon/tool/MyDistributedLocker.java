package com.sofia.poseidon.tool;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import com.muggle.poseidon.base.DistributedLocker;
import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/28
 **/
@Component
public class MyDistributedLocker implements DistributedLocker {
    @Autowired
    RedissonClient redissonClient;

    @Override
    public boolean tryLock(String key, long l) throws InterruptedException {
        return redissonClient.getLock(key).tryLock(l,TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean tryLock() {
        return redissonClient.getLock(this.getClass().toString()).tryLock();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return redissonClient.getLock(this.getClass().toString()).tryLock(time,unit);
    }

    @Override
    public void lock(String key) {
        redissonClient.getLock(key).lock();
    }

    @Override
    public void lock() {
        redissonClient.getLock(this.getClass().toString()).lock();
    }

    @Override
    public void unlock(String key) {
        redissonClient.getLock(key).unlock();
    }

    @Override
    public boolean compareLock(Map<String, String> map) {
        return false;
    }

    @Override
    public boolean tryLock(String s, String s1, int i, TimeUnit timeUnit) {
        return false;
    }

    @Override
    public boolean unlock(String s, String s1) {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        redissonClient.getLock(this.getClass().toString()).lockInterruptibly();
    }

    @Override
    public void unlock() {
        redissonClient.getLock(this.getClass().toString()).unlock();
    }

    @Override
    public Condition newCondition() {
        return redissonClient.getLock(this.getClass().toString()).newCondition();
    }
}
