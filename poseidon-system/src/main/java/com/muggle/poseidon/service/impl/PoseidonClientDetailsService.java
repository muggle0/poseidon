package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.entity.PoseidonClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program: poseidon
 * @description: client
 * @author: muggle
 * @create: 2019-05-24
 **/

@Service
public class PoseidonClientDetailsService implements ClientDetailsService {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        PoseidonClientDetails poseidonClientDetails = new PoseidonClientDetails();
        poseidonClientDetails.setClientId("clientId");
        HashSet<String> scop = new HashSet<>();
        scop.add("scope1");
        scop.add("scope2");
        HashSet<String> strings = new HashSet<>();
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        list.add(()->{
            return "test";
        });
        strings.add("password");
        poseidonClientDetails.setClientSecret(encoder.encode("clientSecret")).setScope(scop).setAuthorities(list).setAuthorizedGrantTypes(strings);
        return poseidonClientDetails;
    }



    /*
    * ResourceOwnerPasswordTokenGranter
    *  这个类在密码模式下校验用户名密码
    * */

    /*
    *   第三方应用校验基于BasicAuthenticationFilter——》DaoAuthenticationProvider  代理类ClientDetailsUserDetailsService
    * */
    /*
    *DefaultTokenServices
    *  if (this.clientDetailsService != null) {
            ClientDetails client = this.clientDetailsService.loadClientByClientId(clientAuth.getClientId());
            return client.getAuthorizedGrantTypes().contains("refresh_token");
        } else {
            return this.supportRefreshToken;
        }
    * */
}
