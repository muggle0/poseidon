package com.muggle.poseidon.entity.form;

import com.muggle.poseidon.entity.pojo.OaAuthority;
import lombok.Data;



@Data
public class AuthorityForm extends OaAuthority {

    private Long roleId;

    private Long authId;


}
