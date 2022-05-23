package com.sofia.poseidon.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.muggle.poseidon.base.exception.SimplePoseidonException;
import com.sofia.poseidon.entity.dto.SysUserDTO;
import com.sofia.poseidon.entity.pojo.SysRole;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.entity.vo.SysUserVO;
import com.sofia.poseidon.manager.UserInfoManager;
import com.sofia.poseidon.mapper.SysRoleMapper;
import com.sofia.poseidon.mapper.SysUserMapper;
import com.sofia.poseidon.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.sofia.poseidon.base.ErrorCode.USER_ERROR;


@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private UserInfoManager userInfoManager;


    @Override
    public void createUser(SysUserDTO sysUser) {
        final UserDetails userDetails = userInfoManager.loadUserByUsername(sysUser.getUsername());
        if (userDetails!=null){
            throw new SimplePoseidonException("账号已存在",USER_ERROR);
        }
        final SysUser user = new SysUser();
        BeanUtils.copyProperties(sysUser,user);
        user.setStatu(1);
        sysUserMapper.insert(user);
        final QueryWrapper<SysRole> roleQuery = new QueryWrapper<>();
        roleQuery.lambda().eq(SysRole::getCode,"normal").eq(SysRole::getStatu,1);
        final SysRole sysRole = sysRoleMapper.selectOne(roleQuery);
        sysRoleMapper.addRoleRelation(user.getId(), Arrays.asList(sysRole.getId()));
        sysUser.setId(user.getId());
    }

    @Override
    public SysUserVO getUserInfo(String name) {
        SysUser sysUser = (SysUser) userInfoManager.loadUserByUsername(name);
        final SysUserVO sysUserVO = new SysUserVO();
        BeanUtils.copyProperties(sysUser,sysUserVO);
        return sysUserVO;
    }

    @Override
    public List<SysUserVO> getUserList(String username, Long current, Long size) {
        final Page<SysUser> page = new Page<>(current.intValue(), size.intValue());
        Page<SysUser> result=sysUserMapper.findAll(username,page);
        for (SysUser sysUser : result) {

        }
        return null;
    }
}
