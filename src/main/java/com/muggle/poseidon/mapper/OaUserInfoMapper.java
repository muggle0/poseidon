package com.muggle.poseidon.mapper;

import java.util.Collection;
import java.util.List;

import com.muggle.poseidon.entity.OaUserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.security.core.GrantedAuthority;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author muggle
 * @since 2020-11-11
 */
public interface OaUserInfoMapper extends BaseMapper<OaUserInfo> {

    List<String> findAuths(List<String> roles);

}
