package com.muggle.poseidon.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * role实体类
 *
 * @author muggle
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Role {
    /***/
    private Long id;
    /***/
    private String roleCode;
    /***/
    private String hashCode;
    /***/
    private String name;
    /***/
    private Integer sort;
    /***/
    private Date createTime;
    /***/
    private Date updateTime;
    /***/
    private Date deleteTime;
    /***/
    private Long createId;
    /***/
    private Long deleteId;
    /***/
    private Long updateId;

    private boolean enable;


}
