package com.muggle.poseidon.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * role实体类
 *
 * @author muggle
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Table(name = "role")
@Entity
@DynamicUpdate
public class Role {
    /***/
    @Id
    @Column(name = "id")
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
    private String id;
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

    @JSONField(serialize = false)
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "role_granted", inverseJoinColumns = {@JoinColumn(name = "granted_id")}, joinColumns = {@JoinColumn(name = "role_id")}, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<PoseidonGrantedAuthority> authorities;


}
