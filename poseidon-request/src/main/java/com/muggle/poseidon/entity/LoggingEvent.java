package com.muggle.poseidon.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * logging_event实体类
 *
 * @author
 *
 */
@Entity
@Table(name = "logging_event")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class LoggingEvent  implements Serializable {
//===========================数据库字段================================
        /***/
        @Column(name = "timestmp")
        private String timestmp;
        /***/
        @Column(name = "formatted_message")
        private String formattedMessage;
        /***/
        @Column(name = "logger_name")
        private String loggerName;
        /***/
        @Column(name = "level_string")
        private String levelString;
        /***/
        @Column(name = "thread_name")
        private String threadName;
        /***/
        @Column(name = "reference_flag")
        private Integer referenceFlag;
        /***/
        @Column(name = "arg0")
        private String arg0;
        /***/
        @Column(name = "arg1")
        private String arg1;
        /***/
        @Column(name = "arg2")
        private String arg2;
        /***/
        @Column(name = "arg3")
        private String arg3;
        /***/
        @Column(name = "caller_filename")
        private String callerFilename;
        /***/
        @Column(name = "caller_class")
        private String callerClass;
        /***/
        @Column(name = "caller_method")
        private String callerMethod;
        /***/
        @Column(name = "caller_line")
        private String callerLine;
        /***/
        @Id
        @Column(name = "event_id")
        private String eventId;
//===========================表关联====================================




//===========================自定义字段=================================

}
