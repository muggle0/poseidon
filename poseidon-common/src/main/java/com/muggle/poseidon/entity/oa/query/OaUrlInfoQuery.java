package com.muggle.poseidon.entity.oa.query;

import com.muggle.poseidon.base.OAException;
import com.muggle.poseidon.base.query.BaseNormalQuery;
import com.muggle.poseidon.base.query.CommonQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
