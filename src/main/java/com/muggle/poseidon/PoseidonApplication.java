package com.muggle.poseidon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@SpringBootApplication
@ServletComponentScan
public class PoseidonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoseidonApplication.class, args);
    }
}
