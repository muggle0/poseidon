package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.entity.PoseidonClientDetails;
import org.springframework.security.core.GrantedAuthority;
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
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        PoseidonClientDetails poseidonClientDetails = new PoseidonClientDetails();
        poseidonClientDetails.setClientId("clientId");
        HashSet<String> scop = new HashSet<>();
        scop.add("scope1");
        scop.add("scope2");

        ArrayList<GrantedAuthority> list = new ArrayList<>();
        list.add(()->{
            return "test";
        });
        poseidonClientDetails.setClientSecret("clientSecret").setScope(scop).setAuthorities(list);
        return poseidonClientDetails;
    }
}
