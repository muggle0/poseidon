package com.muggle.poseidon.model;

import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * user_role实体类
 *
 * @author
 */
@Entity
@Table(name = "user_role")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@DynamicUpdate
public class UserRole implements Serializable {
//===========================数据库字段================================
    /***/
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
    private String id;
    /***/
    @Column(name = "role_id")
    private String roleId;
    /***/
    @Column(name = "user_id")
    private String userId;

    @Column(name = "accredit_id")
    private String accreditId;

}
