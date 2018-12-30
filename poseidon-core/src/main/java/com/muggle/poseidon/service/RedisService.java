package com.muggle.poseidon.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {
    public void set(String key, String value);

    public String get(String key);

    public void setForTimeMS(String key,String value,long time);

    public void setForTimeMIN(String key,String value,long time);

    public void setForTimeCustom(String key,String value,long time,TimeUnit type);

    public String getAndSet(String key,String value);

    public boolean expire(String key,long time,TimeUnit type);

    public boolean persist(String key);

    public Long getExpire(String key);

    public void rename(String key,String newKey);

    public boolean delete(String key);
}
