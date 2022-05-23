package com.sofia.poseidon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sofia.poseidon.entity.dto.SysUserDTO;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.entity.vo.SysUserVO;

import java.util.List;

public interface SysUserService extends IService<SysUser> {

    /**
     * 新建用户
     * @param sysUser
     */
    void createUser(SysUserDTO sysUser);

    /**
     * 获取用户信息
     * @param name
     * @return
     */
    SysUserVO getUserInfo(String name);

    /**
     * 查询用户列表
     * @param username
     * @param current
     * @param size
     * @return
     */
    List<SysUserVO> getUserList(String username, Long current, Long size);
}
