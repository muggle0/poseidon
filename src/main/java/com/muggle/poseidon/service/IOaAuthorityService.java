package com.muggle.poseidon.service;

import com.muggle.poseidon.entity.OaAuthority;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author muggle
 * @since 2020-11-12
 */
public interface IOaAuthorityService extends IService<OaAuthority> {

    Boolean addAuthority(OaAuthority authority);
}
