package com.muggle.poseidon.poseidoncenter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-05-24
 **/


public class SecurityTest extends PoseidonCenterApplicationTests {


    @Autowired
    private TestRestTemplate restTemplate;

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

}
