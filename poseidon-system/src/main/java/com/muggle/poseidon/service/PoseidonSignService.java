package com.muggle.poseidon.service;

import com.muggle.poseidon.model.PoseidonSign;
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

    public PoseidonSign loadByPrincipal(){
        repository.findOne()
    }
}
