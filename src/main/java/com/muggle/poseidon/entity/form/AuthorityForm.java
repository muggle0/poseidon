package com.muggle.poseidon.entity.form;

import javax.validation.constraints.NotNull;

import com.muggle.poseidon.entity.pojo.OaAuthority;
import lombok.Data;



@Data
public class AuthorityForm extends OaAuthority {

    @NotNull(message = "请选择角色")
    private Long roleId;

    @NotNull(message = "请选择权限")
    private Long authId;


}
