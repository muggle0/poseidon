package com.muggle.poseidon.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-05-24
 **/
@Configuration
public class Oauth2ConfigBootstrap {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 令牌存储
     */
    @Bean
    public TokenStore tokenStore() {

        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        // 解决同一username每次登陆access_token都相同的问题
//        redisTokenStore.setAuthenticationKeyGenerator(new RandomAuthenticationKeyGenerator());

        return redisTokenStore;
    }
}
