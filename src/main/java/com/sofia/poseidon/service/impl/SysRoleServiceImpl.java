package com.sofia.poseidon.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sofia.poseidon.entity.pojo.SysRole;
import com.sofia.poseidon.entity.vo.SysRoleVO;
import com.sofia.poseidon.mapper.SysRoleMapper;
import com.sofia.poseidon.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public IPage<SysRoleVO> getAllRole(Long current, Long size) {
        current = (current == null || current <= 0) ? 1 : current;
        size = (size == null || size <= 0) ? 10 : size;
        final Page page = new Page(current, size);
        IPage<SysRoleVO> rolePage = sysRoleMapper.getAllRole(page);
        for (SysRoleVO role : rolePage.getRecords()) {
            List<Long> menuIDs = sysRoleMapper.getMenuId(role.getId());
            role.setMenuIds(menuIDs);
        }
        return rolePage;
    }
}
