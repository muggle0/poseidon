package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.service.OauthService;
import org.springframework.stereotype.Service;

@Service
public class MessageOauthService implements OauthService {
    @Override
    public String getCredentialsByPrincipal(String principal) {
        return "test";
    }
}
