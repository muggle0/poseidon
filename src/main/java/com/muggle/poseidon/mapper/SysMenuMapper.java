package com.muggle.poseidon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muggle.poseidon.entity.pojo.SysMenu;

import java.util.List;


public interface SysMenuMapper extends BaseMapper<SysMenu> {


    /**
     * 获取菜单编码
     * @param id 用户id
     * @return
     */
    List<String> getPermissionByUserId(Long id);
}
