package com.muggle.poseidon.tool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import com.muggle.poseidon.base.DistributedLocker;
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
        return redissonClient.getLock(key).tryLock(l,TimeUnit.SECONDS);
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
