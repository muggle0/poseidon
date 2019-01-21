package com.muggle.poseidon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PoseidonCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoseidonCenterApplication.class, args);
    }

}

