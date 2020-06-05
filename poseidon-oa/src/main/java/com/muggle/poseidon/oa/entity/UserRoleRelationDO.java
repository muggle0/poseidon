package com.muggle.poseidon.oa.entity;

import com.muggle.poseidon.entity.oa.OaRole;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/5
 **/
@Data
@Accessors(chain = true)
public class UserRoleRelationDO extends OaRole {

    private Long userId;

    private String userName;

    public OaRole getOaRole(){
        OaRole oaRole = new OaRole();
        BeanUtils.copyProperties(this,oaRole);
        return oaRole;
    }

}
