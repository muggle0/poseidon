package com.muggle.poseidon.exception;

/**
 * @program: poseidon
 * @description: 没有token的异常
 * @author: muggle
 * @create: 2018-12-22 13:35
 **/

public class NoTokenException extends PoseidonSystemException {
    private static final String MSG="无效token";
    private static final int CODE=1001;
    public NoTokenException() {
        super(MSG,CODE);
    }
}
