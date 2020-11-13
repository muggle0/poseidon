package com.muggle.poseidon.service.manager;

import com.muggle.poseidon.mapper.OaAuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/13
 **/
@Service
public class OaAuthorityManager {
    @Autowired
    private OaAuthorityMapper oaAuthorityMapper;

    public OaAuthorityMapper getOaAuthorityMapper() {
        return oaAuthorityMapper;
    }
}
