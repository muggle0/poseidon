package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.vo.VerifVO;

public interface OauthService {

    ResultBean getVerification(VerifVO verifVO);

    public ResultBean create();
}
