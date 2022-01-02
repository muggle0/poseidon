package com.sofia.poseidon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofia.poseidon.entity.pojo.SysMenu;
import com.sofia.poseidon.mapper.SysMenuMapper;
import com.sofia.poseidon.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
