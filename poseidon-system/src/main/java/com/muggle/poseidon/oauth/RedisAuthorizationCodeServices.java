package com.muggle.poseidon.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: poseidon
 * @description: redis 存储授权码
 * @author: muggle
 * @create: 2019-05-24
 **/
@Component
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Override
    protected void store(String code, OAuth2Authentication oAuth2Authentication) {
        redisTemplate.execute(new RedisCallback<Long>() {

            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(codeKey(code).getBytes(), SerializationUtils.serialize(oAuth2Authentication),
                        Expiration.from(10, TimeUnit.MINUTES), RedisStringCommands.SetOption.UPSERT);
                return 1L;
            }
        });

    }

    @Override
    protected OAuth2Authentication remove(final String code) {
        OAuth2Authentication oAuth2Authentication = redisTemplate.execute(new RedisCallback<OAuth2Authentication>() {

            @Override
            public OAuth2Authentication doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keyByte = codeKey(code).getBytes();
                byte[] valueByte = connection.get(keyByte);

                if (valueByte != null) {
                    connection.del(keyByte);
                    return SerializationUtils.deserialize(valueByte);
                }

                return null;
            }
        });

        return oAuth2Authentication;
    }

    private String codeKey(String code) {
        return "oauth2:codes:" + code;
    }
}
