package com.muggle.poseidon.entity.dto;

import com.muggle.poseidon.entity.pojo.OaAuthority;
import lombok.Data;

@Data
public class OaAuthorityDTO extends OaAuthority {

    private Long roleId;

    private String roleCode;
}
