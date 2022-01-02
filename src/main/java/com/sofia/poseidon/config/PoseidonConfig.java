package com.sofia.poseidon.config;

import com.sofia.poseidon.service.impl.TokenServiceImpl;
import com.sofia.poseidon.tool.MyDistributedLocker;
import org.flywaydb.core.api.callback.BaseCallback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.flywaydb.core.api.callback.Event.AFTER_MIGRATE;

/**
 * Description
 * Date 2022/1/2
 * Created by muggle
 */
@Configuration
public class PoseidonConfig {

    @Autowired
    RedissonClient redissonClient;

    @Bean
    public BaseCallback test(){
        return new BaseCallback() {
            @Override
            public void handle(Event event, Context context) {
                if (event.equals(AFTER_MIGRATE)){
                    redissonClient.getCountDownLatch(TokenServiceImpl.URL_SYNC_LOCK).countDown();
                }
            }
        };
    }
}
