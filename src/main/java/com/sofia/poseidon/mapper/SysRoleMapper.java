package com.sofia.poseidon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sofia.poseidon.entity.pojo.SysRole;
import com.sofia.poseidon.entity.vo.SysRoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户ID查询角色信息
     * @param id
     * @return
     */
    List<SysRole> getRoleByUserId(Long id);

    /**
     * 添加用户权限
     * @param id
     * @param asList
     */
    void addRoleRelation(@Param("id") Long id, @Param("list") List<Long> asList);

    /**
     * 根据用户名获取角色code
     * @param username
     * @return
     */
    List<String> getRoleCode(String username);

    /**
     * 查询角色信息
     * @param page
     * @return
     */
    IPage<SysRoleVO> getAllRole(Page page);

    /**
     * 查询菜单id
     * @param id
     * @return
     */
    List<Long> getMenuId(@Param("id") Long id);
}
