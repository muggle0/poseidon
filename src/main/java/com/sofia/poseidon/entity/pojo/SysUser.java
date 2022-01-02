package com.sofia.poseidon.entity.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muggle.poseidon.base.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author muggle
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OaUserInfo对象", description="")
public class SysUser extends BaseBean implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String avatar;

    private String email;

    private String city;

    private LocalDateTime lastLogin;

    private boolean enabled;

    private String roleCodes;

    private Long id;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roleCodes==null){
            return Collections.emptyList();
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roleCodes);
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}
