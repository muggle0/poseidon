package com.muggle.poseidon.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * poseidon_granted_authority实体类
 *
 * @author muggle
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class PoseidonGrantedAuthority {
    /***/
    private Long id;
    /***/
    private String authority;
    /***/
    private String permissionName;
    /***/
    private Boolean enable;
    /***/
    private String hashCode;
    /***/
    private Long createId;
    /***/
    private Date createTime;
    /***/
    private Long updateId;
    /***/
    private Date updateTime;
    /***/
    private Long deleteId;
    /***/
    private Date deleteTime;


}
