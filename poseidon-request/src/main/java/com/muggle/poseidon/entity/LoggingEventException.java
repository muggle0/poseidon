package com.muggle.poseidon.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * logging_event_exception实体类
 *
 * @author
 *
 */
@Entity
@Table(name = "logging_event_exception")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class LoggingEventException  implements Serializable {
//===========================数据库字段================================
        /***/
        @Id
        @Column(name = "event_id")
        private String eventId;
        /***/
        @Column(name = "i")
        private Integer i;
        /***/
        @Column(name = "trace_line")
        private String traceLine;
//===========================表关联====================================




//===========================自定义字段=================================

}
