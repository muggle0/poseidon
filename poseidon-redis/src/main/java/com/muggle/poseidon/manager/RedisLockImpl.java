package com.muggle.poseidon.manager;

import com.muggle.poseidon.service.RedisLock;
import org.springframework.stereotype.Service;

/**
 * @program: poseidon
 * @description: redis锁
 * @author: muggle
 * @create: 2019-05-21
 **/


@Service
public class RedisLockImpl implements RedisLock {
    @Override
    public boolean lock(String lockKey, String requestId, int expireTime) {
        return false;
    }

    @Override
    public boolean unlock(String lockKey, String requestId) {
        return false;
    }
}
