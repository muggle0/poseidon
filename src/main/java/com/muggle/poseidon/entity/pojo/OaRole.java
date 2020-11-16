package com.muggle.poseidon.entity.pojo;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OaRole对象", description="")
public class OaRole extends BaseBean {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色编码 全链路")
    private String roleCode;

    @ApiModelProperty(value = "是否可用")
    private Boolean enabled;

    private LocalDateTime gmtModified;

    private LocalDateTime gmtCreated;

    private Long gmtCreator;

    private Long gmtModifier;

    @ApiModelProperty(value = "父角色id")
    private Long parentId;

    private String pathCode;


}
