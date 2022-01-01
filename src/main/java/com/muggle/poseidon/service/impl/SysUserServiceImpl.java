package com.muggle.poseidon.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.entity.pojo.SysUser;
import com.muggle.poseidon.mapper.SysUserMapper;
import com.muggle.poseidon.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
