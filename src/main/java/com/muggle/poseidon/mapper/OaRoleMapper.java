package com.muggle.poseidon.mapper;

import java.util.List;

import com.muggle.poseidon.entity.OaRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author muggle
 * @since 2020-11-12
 */
public interface OaRoleMapper extends BaseMapper<OaRole> {

    /**
     * 根据用户id查询权限
     * * @param id
     * @return
     */
    List<String> selectCodeByUserId(Long id);
}
