package com.muggle.poseidon.model;
import com.muggle.poseidon.service.PoseidonIdservice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author muggle
*/

@Accessors(chain = true)
@Entity
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
@Table(name = "poseidon_user_detail")
public class PoseidonSign implements Serializable {

    private static final long serialVersionUID = 1545995920333L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdservice.TYPE)
    private String id;

    /**
    * 
    * isNullAble:1
    */
    private String authType;

    /**
    * 
    * isNullAble:1
    */
    private String principal;

    /**
    * 
    * isNullAble:1
    */
    private String credentials;

    /**
    * 
    * isNullAble:1
    */
    private Integer enable;

    /**
    * 
    * isNullAble:1,defaultVal:CURRENT_TIMESTAMP
    */
    private java.time.LocalDateTime createTime;

    /**
    * 
    * isNullAble:1
    */
    private java.time.LocalDateTime deleteTime;

    /**
    * 
    * isNullAble:1
    */
    private java.time.LocalDateTime updateTime;

    private String userId;

    /**
    * 
    * isNullAble:1
    */

}
