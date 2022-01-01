package com.muggle.poseidon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@SpringBootApplication

public class PoseidonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoseidonApplication.class, args);
    }
}
