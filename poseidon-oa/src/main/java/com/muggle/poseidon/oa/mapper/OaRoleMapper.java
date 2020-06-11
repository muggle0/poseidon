package com.muggle.poseidon.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muggle.poseidon.entity.oa.OaRole;
import com.muggle.poseidon.oa.entity.UserRoleRelationDO;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 插入角色用户关系
     * @param relationDO
     */
    void insertRelation(UserRoleRelationDO relationDO);

    /**
     * 权限查询
     * @param roleCodes
     * @param substring
     * @return
     */
    boolean countAuthByUrl(@Param("roleCodes") List<String> roleCodes, String substring);
}
