package com.muggle.poseidon.service;

import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.repos.PoseidonSignRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-28 20:05
 **/
@Service
@Slf4j
public class PoseidonSignService {
    @Autowired
    PoseidonSignRepository repository;
    @Autowired
    OauthService oauthService;

    public PoseidonSign loadByPrincipal(String principal){
         PoseidonSign poseidonSign = repository.findByPrincipal(principal);
         String credentials = oauthService.getCredentialsByPrincipal(principal);
        poseidonSign.setCredentials(credentials);
         return poseidonSign;
    }
}
