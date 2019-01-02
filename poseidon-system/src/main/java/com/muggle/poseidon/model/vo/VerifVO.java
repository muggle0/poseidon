package com.muggle.poseidon.model.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @program: poseidon
 * @description: 获取验证码
 * @author: muggle
 * @create: 2019-01-02 12:02
 **/
@Data
public class VerifVO {

    private String username;
    @Email
    private String email;
    private String phone;
    @NotNull
    private int code;
}
