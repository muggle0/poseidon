package com.muggle.poseidon.base;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/13
 **/
public enum  OaExceptionEnum {
    RedisError("redis操作异常",1000002),
    OaCheckError("数据校验异常",1000001);



    private String message;

    private Integer code;

    OaExceptionEnum(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }}
