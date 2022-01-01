package com.muggle.poseidon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.entity.pojo.SysMenu;
import com.muggle.poseidon.mapper.SysMenuMapper;
import com.muggle.poseidon.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
