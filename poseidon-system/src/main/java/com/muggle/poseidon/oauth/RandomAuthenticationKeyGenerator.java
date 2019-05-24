package com.muggle.poseidon.oauth;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;

import java.util.UUID;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-05-24
 **/

public class RandomAuthenticationKeyGenerator implements AuthenticationKeyGenerator {
    @Override
    public String extractKey(OAuth2Authentication oAuth2Authentication) {
        return UUID.randomUUID().toString();
    }
}
