package com.muggle.poseidon.base;

public class PoseidonException extends RuntimeException {
    private  String msg;
    private  String code;

    public PoseidonException(String msg, String code){
        super(msg);
        this.msg=msg;
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
