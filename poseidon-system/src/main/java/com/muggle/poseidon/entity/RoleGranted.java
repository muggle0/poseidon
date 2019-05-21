package com.muggle.poseidon.entity;

import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * role_granted实体类
 *
 * @author
 *
 */
@Entity
@Table(name = "role_granted")
@Data
@NoArgsConstructor
@DynamicUpdate
public class RoleGranted implements Serializable {
//===========================数据库字段================================
        /***/
        @Id
        @Column(name = "id")
        @GeneratedValue(generator = "myIdStrategy")
        @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
        private String id;
        /***/
        @Column(name = "granted_id")
        private String grantedId;
        /***/
        @Column(name = "role_id")
        private String roleId;
//===========================表关联====================================




//===========================自定义字段=================================

}
