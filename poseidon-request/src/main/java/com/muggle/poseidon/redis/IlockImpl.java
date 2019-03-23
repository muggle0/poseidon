package com.muggle.poseidon.redis;


import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
public class IlockImpl implements Ilock {
    private static final int LOCK_MAX_EXIST_TIME = 5;  // 单位s，一个线程持有锁的最大时间
    private static final String LOCK_PREX = "lock_"; // 作为锁的key的前缀

    private StringRedisTemplate redisTemplate;
    private String lockPrex; // 做为锁key的前缀
    private int lockMaxExistTime; // 单位s，一个线程持有锁的最大时间

    private ThreadLocal<String> threadId = new ThreadLocal<String>();  // 线程变量

    public IlockImpl(StringRedisTemplate redisTemplate){
        this(redisTemplate, LOCK_PREX, LOCK_MAX_EXIST_TIME);
    }

    public IlockImpl(StringRedisTemplate redisTemplate, String lockPrex, int lockMaxExistTime){
        this.redisTemplate = redisTemplate;
        this.lockPrex = lockPrex;
        this.lockMaxExistTime = lockMaxExistTime;
    }

    @Override
    public void lock(String lock){
        Assert.notNull(lock, "lock can't be null!");
        String lockKey = getLockKey(lock);
        BoundValueOperations<String,String> keyBoundValueOperations = redisTemplate.boundValueOps(lockKey);
        while(true){
            // 如果上次拿到锁的是自己，则本次也可以拿到锁：实现可重入
            String value = keyBoundValueOperations.get();
            // 根据传入的值，判断用户是否持有这个锁
            if(value != null && value.equals(String.valueOf(threadId.get()))){
                // 重置过期时间
                keyBoundValueOperations.expire(lockMaxExistTime, TimeUnit.SECONDS);
                break;
            }

            if(keyBoundValueOperations.setIfAbsent(lockKey)){
                // 每次获取锁时，必须重新生成id值
                String keyUniqueId = UUID.randomUUID().toString(); // 生成key的唯一值
                threadId.set(keyUniqueId);
                // 显设置value，再设置过期日期，否则过期日期无效
                keyBoundValueOperations.set(String.valueOf(keyUniqueId));
                // 为了避免一个用户拿到锁后，进行过程中没有正常释放锁，这里设置一个默认过期实际，这段非常重要，如果没有，则会造成死锁
                keyBoundValueOperations.expire(lockMaxExistTime, TimeUnit.SECONDS);
                // 拿到锁后，跳出循环
                break;
            }else{
                try {
                    // 短暂休眠，nano避免出现活锁
                    Thread.sleep(10, (int)(Math.random() * 500));
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
}
