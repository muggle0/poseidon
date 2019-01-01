package com.muggle.poseidon.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.*;

/**
 * @author muggle
 */

@Accessors(chain = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Data
@ToString
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
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
    private String id;

    /**
     * 用户名
     * isNullAble:1
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 昵称
     * isNullAble:1
     */
    @NotNull(message = "昵称不能为空")
    private String nickname;

    /**
     * isNullAble:1
     */
    @NotNull(message = "密码不能为空")
//    @Pattern(regexp = "^.{3,16}$",message = "密码必须为6到16位（字母，数字，下划线，减号）")
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
    @Email
    private String email;

    /**
     * 创建时间
     * isNullAble:1,defaultVal:CURRENT_TIMESTAMP
     */
    private Date creatTime;

    /**
     * isNullAble:1
     */
    private Date updateTime;

    /**
     * isNullAble:1
     */
    private Date deleteTime;
    @Transient
    private Set<PoseidonGrantedAuthority> authorities;


    @JSONField(serialize = false)
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", inverseJoinColumns = {@JoinColumn(name = "role_id")}, joinColumns = {@JoinColumn(name = "user_id")}, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<Role> roles;
//    @Override
   /* public Set<PoseidonGrantedAuthority> getAuthorities() {
        HashSet<PoseidonGrantedAuthority> authorities=new HashSet<>();
        if (roles.size()>0){
            roles.forEach(role -> {
                if (role.isEnable()){
                    Set<PoseidonGrantedAuthority> temp = role.getAuthorities();
                    authorities.addAll(temp);
                }
            });
        }
        authorities.add(new PoseidonGrantedAuthority().setAuthority("ROLE_test"));
        return authorities;
    }*/


}
