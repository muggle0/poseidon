package com.muggle.poseidon.model;

import com.muggle.poseidon.core.generater.PoseidonIdGener;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: poseidon
 * @description: 用户消息
 * @author: muggle
 * @create: 2019-01-04 12:34
 **/


@Entity
@Table(name = "user_message")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@DynamicUpdate
public class UserMessage {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = PoseidonIdGener.TYPE)
    private String id;

    private Integer markRead;

    private String messageType;

    private String content;

    private String createId;

    private String userId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
