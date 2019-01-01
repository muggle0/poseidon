package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;

public interface OauthService {
    String getCredentialsByPrincipal(String principal );

    ResultBean getVerification(PoseidonUserDetail poseidonUserDetail);

    public ResultBean create();
}
