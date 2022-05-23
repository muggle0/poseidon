package com.sofia.poseidon.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sofia.poseidon.entity.pojo.SysRole;
import com.sofia.poseidon.entity.vo.SysRoleVO;

public interface SysRoleService extends IService<SysRole> {

    IPage<SysRoleVO> getAllRole(Long current, Long size);
}
