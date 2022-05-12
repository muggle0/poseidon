package com.sofia.poseidon.entity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Description
 * Date 2022/5/12
 * Created by muggle
 */
@Data
public class SysUserDTO  {
    @NotNull(message = "请输入用户名")
    private String username;

    @NotNull(message = "请输入密码")
    private String password;

    private String avatar;

    @Email(message = "邮箱格式错误")
    private String email;

    private String city;

    private Long id;
}
