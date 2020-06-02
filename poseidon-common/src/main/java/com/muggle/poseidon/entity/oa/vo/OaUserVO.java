package com.muggle.poseidon.entity.oa.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/2
 **/

@Data
public class OaUserVO {
    @NotNull(message="请选择性别")
    private Integer gender;

    @NotNull(message="请输入用户名")
    @Pattern(regexp = "^[A-Za-z_@.]{6,10}$",message = "用户名必须是6-10位之间的字母、下划线、@、.，并且不能以数字开头")
    private String username;

    @NotNull(message="请输入密码")
    @Pattern(regexp = "^[A-Za-z_@.]{6,10}$",message = "密码必须是6-10位之间的字母、下划线、@、.，并且不能以数字开头")
    private String password;

    @Email(message="邮箱格式错误")
    private String email;

    private String imgUrl;
}
