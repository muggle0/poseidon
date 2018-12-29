package com.muggle.poseidon.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.muggle.poseidon.service.PoseidonIdservice;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdservice.TYPE)
    private String id;

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




    @JSONField(serialize = false)
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", inverseJoinColumns = {@JoinColumn(name = "role_id")}, joinColumns = {@JoinColumn(name = "user_id")}, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<Role> roles;
    @Override
    public Set<PoseidonGrantedAuthority> getAuthorities() {
        HashSet<PoseidonGrantedAuthority> authorities=new HashSet<>();
        if (roles.size()>0){
            roles.forEach(role -> {
                if (role.isEnable()){
                    Set<PoseidonGrantedAuthority> temp = role.getAuthorities();
                    authorities.addAll(temp);
                }
            });
        }
        return authorities;
    }


}
