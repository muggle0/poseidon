package com.muggle.poseidon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.muggle.poseidon.base.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author muggle
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OaDept对象", description="")
public class OaDept extends BaseBean {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;

    private String deptAddr;

    private String deptFax;

    private String deptName;

    private String deptTel;

    private String email;

    private Long deptmanager;

    private LocalDateTime endTime;

    private LocalDateTime startTime;


}
