package com.sofia.poseidon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sofia.poseidon.entity.dto.SysMenuDTO;
import com.sofia.poseidon.entity.pojo.SysMenu;
import com.sofia.poseidon.entity.vo.SysUserVO;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {


    SysUserVO getUserMenu(String name);

    SysMenuDTO getMenuById(Long id);

    List<SysMenuDTO> getMenuTree(String name);

    int insertMenu(SysMenuDTO sysMenu);

}
