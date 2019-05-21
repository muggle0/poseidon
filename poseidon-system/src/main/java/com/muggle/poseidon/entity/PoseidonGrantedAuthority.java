package com.muggle.poseidon.entity;

import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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
@DynamicInsert
public class PoseidonGrantedAuthority implements GrantedAuthority {
    /***/
    @Id
    @Column(name = "id")
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
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

    private String url;

    private String method;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoseidonGrantedAuthority that = (PoseidonGrantedAuthority) o;
        return Objects.equals(authority, that.authority) &&
                Objects.equals(permissionName, that.permissionName) &&
                Objects.equals(url, that.url) &&
                Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority, permissionName, url, method);
    }
}
