package com.muggle.poseidon.core.exception;

import org.springframework.security.access.AccessDeniedException;

/**
 * @program: poseidon
 * @description: 系统异常父类
 * @author: muggle
 * @create: 2018-12-22 13:32
 **/

public class PoseidonAccessException extends AccessDeniedException {
    private String msg;
    private String code;
    public PoseidonAccessException(String msg , String code){
        super(msg);
        this.msg=msg;
        this.code=code;
    }
}
