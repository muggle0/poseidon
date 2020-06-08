package com.muggle.poseidon.entity.oa.query;

import com.muggle.poseidon.base.query.CommonQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/6
 **/
@Data
public class OaUrlInfoQuery extends CommonQuery {

    @ApiModelProperty(value = "是否有效")
    private Boolean enable;

    @ApiModelProperty(value = "请求类型")
    private String requestType;

    @ApiModelProperty(value = "类名")
    private String className;

    @ApiModelProperty(value = "方法名")
    private String methodName;

    @ApiModelProperty(value = "请求路径")
    private String url;

    @ApiModelProperty(value = "描述")
    private String description;

}
