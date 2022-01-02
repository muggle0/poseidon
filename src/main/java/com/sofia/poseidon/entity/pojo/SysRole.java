package com.sofia.poseidon.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.muggle.poseidon.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;

    private String code;

    private LocalDateTime created;

    private LocalDateTime updated;


    private String remark;


}
