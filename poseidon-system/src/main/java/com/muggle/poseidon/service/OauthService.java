package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.vo.VerifVO;

public interface OauthService {

    ResultBean getVerification(VerifVO verifVO);

    public ResultBean create();
}
