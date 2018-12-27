package com.muggle.poseidon.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-24 21:01
 **/
@Service
public class PoseidonUserdetailsService implements UserDetailsService{


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
