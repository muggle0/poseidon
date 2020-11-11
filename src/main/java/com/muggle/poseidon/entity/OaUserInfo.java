package com.muggle.poseidon.entity;

import java.time.LocalDateTime;
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
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OaUserInfo对象", description="")
public class OaUserInfo extends BaseBean {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "银行卡号")
    private String bank;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birth;

    @ApiModelProperty(value = "邮箱")
    private String eamil;

    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    @ApiModelProperty(value = "头像")
    private String imgPath;

    @ApiModelProperty(value = "未锁定")
    private Boolean accountNonLocked;

    private LocalDateTime gmtModified;

    private Long modifyUserId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "用户薪水")
    private Float salary;

    @ApiModelProperty(value = "毕业院校")
    private String userSchool;

    @ApiModelProperty(value = "性别")
    private Boolean gender;

    @ApiModelProperty(value = "学历")
    private String userEdu;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "个性签名")
    private String userSign;

    private String userTel;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "未过期")
    private Boolean accountNonExpired;

    @ApiModelProperty(value = "凭证有效")
    private Boolean credentialsNonExpired;

    @ApiModelProperty(value = "可用")
    private Boolean enabled;

    @ApiModelProperty(value = "用户编码")
    private String userCode;
}
