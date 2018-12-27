package com.muggle.poseidon.model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author muggle
*/
@Data
@Accessors(chain = true)
public class PoseidonUserDetail implements Serializable {

    private static final long serialVersionUID = 1545900520305L;


    /**
    * 主键
    * user_detail
    * isNullAble:0
    */
    private Long id;

    /**
    * 用户名
    * isNullAble:1
    */
    private String username;

    /**
    * 昵称
    * isNullAble:1
    */
    private String nickname;

    /**
    * 
    * isNullAble:1
    */
    private String password;

    /**
    * 账户未过期
    * isNullAble:1,defaultVal:1
    */
    private Integer accountNonExpired;

    /**
    * 账户未上锁
    * isNullAble:1
    */
    private Integer accountNonLocked;

    /**
    * 凭证未过期
    * isNullAble:1,defaultVal:1
    */
    private Integer credentiaIsNonExpired;

    /**
    * 激活
    * isNullAble:1,defaultVal:1
    */
    private Integer enabled;

    /**
    * 
    * isNullAble:1
    */
    private String hashCode;

    /**
    * 
    * isNullAble:1
    */
    private String imgUrl;

    /**
    * 
    * isNullAble:1
    */
    private String phone;

    /**
    * 
    * isNullAble:1
    */
    private Integer 
gender;

    /**
    * 
    * isNullAble:1
    */
    private Long creatId;

    /**
    * 
    * isNullAble:1
    */
    private Long updateId;

    /**
    * 
    * isNullAble:1
    */
    private Long deleteId;

    /**
    * 创建时间
    * isNullAble:1,defaultVal:CURRENT_TIMESTAMP
    */
    private java.time.LocalDateTime creatTime;

    /**
    * 
    * isNullAble:1
    */
    private java.time.LocalDateTime updateTime;

    /**
    * 
    * isNullAble:1
    */
    private java.time.LocalDateTime deleteTime;

}
