package com.muggle.poseidon.core.exception;

import org.springframework.security.access.AccessDeniedException;

/**
 * @program: poseidon
 * @description: 系统异常父类
 * @author: muggle
 * @create: 2018-12-22 13:32
 **/

public class PoseidonSystemException extends AccessDeniedException {
    private String msg;
    private int code;
    public PoseidonSystemException(String msg ,int code){
        super(msg);
        this.msg=msg;
        this.code=code;
    }
}
