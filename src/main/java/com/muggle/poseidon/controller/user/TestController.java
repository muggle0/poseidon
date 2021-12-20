package com.muggle.poseidon.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * Date 2021/11/4
 * Created by muggle
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/encode")
    public String getEncode(String code){
        return passwordEncoder.encode(code);
    }
}
