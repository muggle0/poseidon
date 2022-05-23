package com.sofia.poseidon.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Description
 * Date 2022/5/23
 * Created by muggle
 */
@Data
public class SysRoleVO {


    private static final long serialVersionUID = 1L;

    private String name;

    private String code;

    private LocalDateTime created;

    private LocalDateTime updated;


    private String remark;

    private Integer statu;

    @TableId(value="id",type= IdType.ASSIGN_ID)
    private Long id;

    private List<Long> menuIds;

}
