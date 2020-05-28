package com.muggle.poseidon.config;

import com.muggle.poseidon.base.DistributedLocker;
import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/28
 **/
@Service
public class MyDistributedLocker implements DistributedLocker {
    @Override
    public boolean trylock(String s, Long aLong) {
        return false;
    }

    @Override
    public void dolock(String s, String s1, Long aLong) throws BasePoseidonCheckException {

    }

    @Override
    public boolean unlock(String s, String s1) {
        return false;
    }

    @Override
    public void clean(String s) {

    }
}
