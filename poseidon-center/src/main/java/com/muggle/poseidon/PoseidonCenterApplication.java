package com.muggle.poseidon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PoseidonCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoseidonCenterApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println(strings);
            }
        };
    }
}

