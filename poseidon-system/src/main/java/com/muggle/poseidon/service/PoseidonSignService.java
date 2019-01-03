package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonSign;

public interface PoseidonSignService {
    ResultBean getSigns();

    ResultBean insert(PoseidonSign poseidonSign, String validata);

    ResultBean update(PoseidonSign poseidonSign, String validata);

    ResultBean delete(String id);
}
