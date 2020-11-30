package com.muggle.poseidon.mapper;

import java.util.List;

import com.muggle.poseidon.entity.dto.OaRoleDTO;
import com.muggle.poseidon.entity.pojo.OaRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author muggle
 * @since 2020-11-12
 */
@Repository
public interface OaRoleMapper extends BaseMapper<OaRole> {

    /**
     * 根据用户id查询权限
     * * @param id
     * @return
     */
    List<String> selectCodeByUserId(Long id);

    /**
     * 插入用户角色中间表
     * @param roleDTOList
     * @return
     */
    int insertRelation(List<OaRoleDTO> roleDTOList);
}
