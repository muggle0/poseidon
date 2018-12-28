package com.muggle.poseidon.model;

import com.muggle.poseidon.service.PoseidonIdservice;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author muggle
 */

@Accessors(chain = true)
@Entity
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
@Table(name = "poseidon_user_detail")
public class PoseidonUserDetail  implements Serializable ,UserDetails {

    private static final long serialVersionUID = 1545900520305L;


    /**
     * 主键
     * user_detail
     * isNullAble:0
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdservice.TYPE)
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
     * isNullAble:1
     */
    private String password;

    /**
     * 账户未过期
     * isNullAble:1,defaultVal:1
     */
    private boolean accountNonExpired;

    /**
     * 账户未上锁
     * isNullAble:1
     */
    private boolean accountNonLocked;

    /**
     * 凭证未过期
     * isNullAble:1,defaultVal:1
     */
    private boolean CredentialsNonExpired;

    /**
     * 激活
     * isNullAble:1,defaultVal:1
     */
    private boolean enabled;

    /**
     * isNullAble:1
     */
    private String hashCode;

    /**
     * isNullAble:1
     */
    private String imgUrl;

    /**
     * isNullAble:1
     */
    private String phone;

    /**
     * isNullAble:1
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * isNullAble:1
     */
    private Long creatId;

    /**
     * isNullAble:1
     */
    private Long updateId;

    /**
     * isNullAble:1
     */
    private Long deleteId;

    /**
     * 创建时间
     * isNullAble:1,defaultVal:CURRENT_TIMESTAMP
     */
    private java.time.LocalDateTime creatTime;

    /**
     * isNullAble:1
     */
    private java.time.LocalDateTime updateTime;

    /**
     * isNullAble:1
     */
    private java.time.LocalDateTime deleteTime;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }




}
