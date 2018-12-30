package com.muggle.poseidon.core.exception;

import  com.muggle.poseidon.core.properties.TokenProperties;

import org.springframework.security.core.AuthenticationException;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-24 15:06
 **/
public class BadTokenException extends AuthenticationException {
    private String code;
    private String msg;
    public BadTokenException(String msg,String code){
        super(msg);
        this.msg=msg;
        this.code=code;
    }
}
