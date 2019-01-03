package com.muggle.poseidon.core.properties;

public interface TokenProperties {

    String NO_TOKEN_MESSAGE = "数据非法，没有token";
    String BAD_TOKEN_MSG = "用户名或密码有误";
    String BAD_TOKEN_CODE = "401";
    Integer MESSAGE_CODE=2;
    Integer EMAIL_CODE=3;
    String VERIFICATION="verification";
    String IS_MESSAGE="isMessage";
    String ABNORMAL_ACCOUNT="账号异常";
    String BAD_VERIFICATION="请重新获取验证码";

}
