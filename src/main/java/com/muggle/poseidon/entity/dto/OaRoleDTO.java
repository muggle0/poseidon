package com.muggle.poseidon.entity.dto;

import com.muggle.poseidon.entity.pojo.OaRole;
import lombok.Data;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/18
 **/
@Data
public class OaRoleDTO extends OaRole {
    private Long userId;

    private String username;
}
