package com.sofia.poseidon.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.mapper.SysUserMapper;
import com.sofia.poseidon.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
