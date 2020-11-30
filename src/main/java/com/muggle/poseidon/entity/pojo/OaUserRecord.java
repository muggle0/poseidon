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
 * 用户日志
 * </p>
 *
 * @author muggle
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OaUserRecord对象", description="用户日志")
public class OaUserRecord extends BaseBean {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    @ApiModelProperty(value = "日志类型 1-登录日志 2-接口日志 3-黑名单日志")
    private Integer recordType;

    @ApiModelProperty(value = "接口入参")
    private String recordArgs;

    @ApiModelProperty(value = "接口返回值")
    private String recordResult;

    @ApiModelProperty(value = "访问名字")
    private String username;

    @ApiModelProperty(value = "访问用户")
    private Long userId;

    @ApiModelProperty(value = "访问时间")
    private LocalDateTime recordTime;

    @ApiModelProperty(value = "url")
    private String recordUrl;

    @ApiModelProperty(value = "url id")
    private Long recordUrlId;

    @ApiModelProperty(value = "ip地址")
    private String ipAddr;

}
