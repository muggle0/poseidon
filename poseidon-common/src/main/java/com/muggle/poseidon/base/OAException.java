package com.muggle.poseidon.base;

import com.muggle.poseidon.base.exception.BasePoseidonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/26
 **/
public class OAException extends BasePoseidonException {
    private static final Logger log = LoggerFactory.getLogger(OAException.class);

    private Integer code =1001;

    public OAException(String message) {
        super(message);
    }

    public OAException(String message,Integer code) {
        super(message);
        this.code=code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

}
