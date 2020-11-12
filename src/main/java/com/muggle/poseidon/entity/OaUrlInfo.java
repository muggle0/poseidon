package com.muggle.poseidon.entity;

import java.util.Date;

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
@ApiModel(value = "OaUrlInfo对象", description = "")
public class OaUrlInfo extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String url;

    @TableId
    private Long id;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "是否有效")
    private Boolean enable;

    @ApiModelProperty(value = "请求类型")
    private String requestType;

    @ApiModelProperty(value = "类名")
    private String className;

    @ApiModelProperty(value = "方法名")
    private String methodName;

    @ApiModelProperty(value = "父行id")
    private Long parentId;

    private String parentUrl;


}
