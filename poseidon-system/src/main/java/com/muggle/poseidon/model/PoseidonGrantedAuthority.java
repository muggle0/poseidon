package com.muggle.poseidon.model;

import com.muggle.poseidon.service.PoseidonIdservice;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
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
@Table(name = "poseidon_granted_authority")
@Entity
@DynamicUpdate
public class PoseidonGrantedAuthority implements GrantedAuthority {
    /***/
    @Id
    @Column(name = "id")
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdservice.TYPE)
    private String id;
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
