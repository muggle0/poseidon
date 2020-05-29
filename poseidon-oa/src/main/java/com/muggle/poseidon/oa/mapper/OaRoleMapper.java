package com.muggle.poseidon.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muggle.poseidon.entity.oa.OaRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
public interface OaRoleMapper extends BaseMapper<OaRole> {

    /**
     * 根据用户名获取权限
     * @param username
     * @return
     */
    List<OaRole> selectByUsername(String username);
}
