package com.muggle.poseidon.base;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/29
 **/
public class OACheckedException extends BasePoseidonCheckException {
    private Integer code=1001;
    public OACheckedException(String message) {
        super(message);
    }

    public OACheckedException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
