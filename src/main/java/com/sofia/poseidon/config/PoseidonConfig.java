package com.sofia.poseidon.config;

import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.context.annotation.Bean;
import org.flywaydb.core.api.callback.BaseCallback;
import org.springframework.context.annotation.Configuration;

import static org.flywaydb.core.api.callback.Event.AFTER_INFO;

/**
 * Description
 * Date 2022/1/2
 * Created by muggle
 */
@Configuration
public class PoseidonConfig {

    @Bean
    public BaseCallback test(){
        return new BaseCallback() {
            @Override
            public void handle(Event event, Context context) {
                if (event.equals(AFTER_INFO)){

                }
            }
        };
    }
}
