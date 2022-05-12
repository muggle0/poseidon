package com.sofia.poseidon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sofia.poseidon.entity.dto.SysUserDTO;
import com.sofia.poseidon.entity.pojo.SysUser;

public interface SysUserService extends IService<SysUser> {

    /**
     * 新建用户
     * @param sysUser
     */
    void createUser(SysUserDTO sysUser);
}
