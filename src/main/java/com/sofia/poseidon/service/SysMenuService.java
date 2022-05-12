package com.sofia.poseidon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sofia.poseidon.entity.pojo.SysMenu;
import com.sofia.poseidon.entity.vo.SysUserVO;

public interface SysMenuService extends IService<SysMenu> {


    SysUserVO getUserMenu(String name);
}
