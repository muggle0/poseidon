package com.muggle.poseidon.entity;

import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * poseidon_black_list实体类
 *
 * @author
 */
@Entity
@Table(name = "poseidon_black_list")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@DynamicUpdate
public class PoseidonBlackList implements Serializable {
//===========================数据库字段================================
    /***/
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
    private String id;
    /***/
    @Column(name = "user_id")
    private String userId;
    /***/
    @Column(name = "remark")
    private String remark;
    /***/
    @Column(name = "reason")
    private String reason;
    /***/
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;
    /***/
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updateTime;
    /***/
    @Column(name = "delete_time")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date deleteTime;
    /***/
    @Column(name = "status")
    private Integer status;
//===========================表关联====================================


//===========================自定义字段=================================

}
