package com.muggle.poseidon.base;

import com.muggle.poseidon.util.PoseidonIdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/28
 **/
@Service
public class OaIdGenerator extends PoseidonIdGenerator {
    public OaIdGenerator(){
        super(10L,10L);
    }

    @Override
    public String getNextSerialNumber(String s, String s1, int i) {
        return null;
    }

    @Override
    public List<String> getBatchSerialNumber(String s, String s1, int i, int i1) {
        return null;
    }

    @Override
    public long nextId() {
        return simpleNextId();
    }
}
