package com.muggle.poseidon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-28 17:52
 **/
@RestController
@RequestMapping(value = "/public")
public class ApiTestController {
    @GetMapping("/my")
    public String get(){
        return "你好啊";
    }
}
