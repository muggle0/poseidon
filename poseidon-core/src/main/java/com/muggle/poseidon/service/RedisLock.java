package com.muggle.poseidon.service;

public interface RedisLock {
    boolean lock(String lockKey, String requestId, int expireTime);

    boolean unlock(String lockKey, String requestId);
}
