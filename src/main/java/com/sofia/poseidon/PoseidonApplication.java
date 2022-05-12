package com.sofia.poseidon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PoseidonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoseidonApplication.class, args);
    }
}
