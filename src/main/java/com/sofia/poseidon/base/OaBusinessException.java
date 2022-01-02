package com.sofia.poseidon.base;

import com.muggle.poseidon.base.exception.BasePoseidonException;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/13
 **/
public class OaBusinessException extends BasePoseidonException {
    private Integer code;
    public OaBusinessException(String message,Integer code) {
        super(message);
        this.code=code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public OaBusinessException(OaExceptionEnum oaExceptionEnum) {
        super(oaExceptionEnum.getMessage());
        this.code=oaExceptionEnum.getCode();
    }

    public OaBusinessException(OaExceptionEnum exceptionEnum,Throwable e){
        super(exceptionEnum.getMessage(),e);
        this.code=exceptionEnum.getCode();
    }

}
