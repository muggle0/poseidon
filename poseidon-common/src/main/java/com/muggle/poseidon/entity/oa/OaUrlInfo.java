package com.muggle.poseidon.entity.oa;

import java.time.LocalDate;

import com.muggle.poseidon.base.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="OaUrlInfo对象", description="")
public class OaUrlInfo extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String url;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDate gmtCreate;

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


}
