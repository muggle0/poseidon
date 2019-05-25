package com.muggle.poseidon.poseidoncenter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-05-24
 **/


public class SecurityTest extends PoseidonCenterApplicationTests {


    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    TokenStore tokenStore;

    @Test
    public void token_password() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("username", "admin");
        params.add("password", "admin");
        params.add("scope", "scope1 scope2");
//        第三方应用登陆
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
//                用户的用户名密码
        postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }


    @Test
    public void test(){
        Collection<OAuth2AccessToken> clientId = tokenStore.findTokensByClientId("clientId");
        System.out.println("test");
    }

    @Test
    public void test2(){
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken("c88834c9-c5ce-4df8-b0e5-2397232024e8");
        System.out.println("test");
    }
}
