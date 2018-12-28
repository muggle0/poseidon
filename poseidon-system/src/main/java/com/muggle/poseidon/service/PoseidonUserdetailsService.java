package com.muggle.poseidon.service;

import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.repos.PoseidonUserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-24 21:01
 **/
@Service
@Slf4j
public class PoseidonUserdetailsService implements UserDetailsService{
    @Autowired
    PoseidonUserDetailsRepository repository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        PoseidonUserDetail userDetail=repository.findDistinctByUsername(s);
        log.info("用户登录验证："+userDetail.toString());
        return  userDetail;
    }

    public void toSignIn(PoseidonUserDetail userDetail) {
        log.info("创建用户："+ userDetail.toString());
        String w = passwordEncoder.encode("ww");
        userDetail.setUsername("ww").setGender(0).setNickname("wos").setImgUrl("hah").setPassword(w);
        repository.save(userDetail);
    }
}
