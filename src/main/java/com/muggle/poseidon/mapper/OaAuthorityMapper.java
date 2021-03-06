package com.muggle.poseidon.mapper;

import java.util.List;

import com.muggle.poseidon.entity.dto.OaAuthorityDTO;
import com.muggle.poseidon.entity.pojo.OaAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author muggle
 * @since 2020-11-12
 */
public interface OaAuthorityMapper extends BaseMapper<OaAuthority> {

    int insertRelation(List<OaAuthorityDTO> authorityDTOList);
}
