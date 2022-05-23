package com.sofia.poseidon.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.sofia.poseidon.entity.pojo.SysUser;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {


    Page<SysUser> findAll(String username, Page<SysUser> page);
}
