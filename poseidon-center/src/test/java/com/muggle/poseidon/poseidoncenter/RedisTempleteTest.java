package com.muggle.poseidon.poseidoncenter;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.List;

public class RedisTempleteTest extends PoseidonCenterApplicationTests{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test1(){
       /* DefaultRedisScript<List> script = new DefaultRedisScript<>();
        script.setResultType(List.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/LimitLoadTimes.lua"))););
        redisTemplate.*/
    }
}
