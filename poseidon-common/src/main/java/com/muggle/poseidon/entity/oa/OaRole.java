package com.muggle.poseidon.entity.oa;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muggle.poseidon.base.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Date;

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
public class OaRole extends BaseBean implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @ApiModelProperty(value = "权限名称")
    private String roleName;

    @ApiModelProperty(value = "权限编号")
    private String roleCode;

    @ApiModelProperty(value = "是否有效")
    private Boolean enabled;

    private Date gmtModified;

    private Date gmtCreated;

    private Long gmtCreator;

    private Long gmtModifier;

    @ApiModelProperty(value = "父行id")
    private Long parentId;


    @Override
    public String getAuthority() {
        return roleCode;
    }
}
