package com.muggle.poseidon.controller;

import com.muggle.poseidon.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: poseidon
 * @description: 测试reids
 * @author: muggle
 * @create: 2018-12-21 17:06
 **/
@Controller
public class TestController {
    @Autowired
    RedisService redisService;

    @GetMapping("/poseidon/test")
    public String testRedis(){
        redisService.set("a","b");
        String a =(String) redisService.get("a");
        return a;
    }
}