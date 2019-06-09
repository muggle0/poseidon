package com.muggle.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @GetMapping("/a")
    public String test(){
        redisTemplate.opsForValue().set("test","test");
        return "test";
    }

    @GetMapping("/b")
    public String getValue(){
        String test = redisTemplate.opsForValue().get("test");
        return test;
    }
}
