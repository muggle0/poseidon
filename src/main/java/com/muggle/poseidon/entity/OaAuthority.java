package com.muggle.poseidon.entity;

import java.time.LocalDateTime;
import com.muggle.poseidon.base.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author muggle
 * @since 2020-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OaAuthority对象", description="权限表")
public class OaAuthority extends BaseBean {

    private static final long serialVersionUID = 1L;

    private LocalDateTime gmtCreated;

    private Long gmtCreator;

    private LocalDateTime gmtModified;

    private Long gmtModifitor;

    @ApiModelProperty(value = "权限编码")
    private String authCode;

    @ApiModelProperty(value = "权限名称")
    private String authName;

    @ApiModelProperty(value = "权限描述")
    private String authDesc;


}
