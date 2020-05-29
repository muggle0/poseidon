package com.muggle.poseidon.entity.oa;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muggle.poseidon.base.BaseBean;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="OaRole对象", description="")
public class OaRole extends BaseBean {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    private String roleName;

    private Integer roleCode;

    private Boolean enabled;

    private LocalDateTime gmtModified;

    private LocalDateTime gmtCreated;

    private Long gmtCreator;

    private Long gmtModifier;

    private Long parentId;


}
