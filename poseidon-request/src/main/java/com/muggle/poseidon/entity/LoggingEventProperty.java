package com.muggle.poseidon.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * logging_event_property实体类
 *
 * @author
 *
 */
@Entity
@Table(name = "logging_event_property")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class LoggingEventProperty  implements Serializable {
//===========================数据库字段================================
        /***/
        @Id
        @Column(name = "event_id")
        private String eventId;
        /***/
        @Column(name = "mapped_key")
        private String mappedKey;
        /***/
        @Column(name = "mapped_value")
        private String mappedValue;
//===========================表关联====================================




//===========================自定义字段=================================

}
