package com.muggle.poseidon.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muggle.poseidon.entity.pojo.SysRole;
import com.muggle.poseidon.entity.pojo.SysUser;
import com.muggle.poseidon.mapper.SysMenuMapper;
import com.muggle.poseidon.mapper.SysRoleMapper;
import com.muggle.poseidon.mapper.SysUserMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@Service
@Getter
public class UserInfoManager {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysMenuMapper menuMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    public UserDetails loadUserByUsername(String username) {
        QueryWrapper<SysUser> oaUserInfoQueryWrapper = new QueryWrapper<>();
        oaUserInfoQueryWrapper.lambda().eq(SysUser::getUsername,username);
        SysUser sysUser = userMapper.selectOne(oaUserInfoQueryWrapper);
        return sysUser;
    }

    public String getPermissionByUserId(Long id) {
        List<String> result=menuMapper.getPermissionByUserId(id);
        final List<SysRole> roles = sysRoleMapper.getRoleByUserId(id);
        final String content = String.join(",", result).concat(",").concat(roles.stream()
            .map(r -> "ROLE_".concat(r.getCode())).collect(Collectors.joining(",")));
        return content;
    }
}
