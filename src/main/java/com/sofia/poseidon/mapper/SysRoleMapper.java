package com.sofia.poseidon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sofia.poseidon.entity.pojo.SysRole;

import java.util.List;


public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户ID查询角色信息
     * @param id
     * @return
     */
    List<SysRole> getRoleByUserId(Long id);

}
