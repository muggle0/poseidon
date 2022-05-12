package com.sofia.poseidon.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sofia.poseidon.entity.pojo.SysRole;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.mapper.SysMenuMapper;
import com.sofia.poseidon.mapper.SysRoleMapper;
import com.sofia.poseidon.mapper.SysUserMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
        final List<String> collect = roles.stream()
            .map(r -> "ROLE_".concat(r.getCode())).collect(Collectors.toList());
        collect.addAll(result);
        final String join = String.join(",", collect);
        return join;
    }

    public static void main(String[] args) {
        List<String> test =new ArrayList<>();
        test.add("x1");
        test.add("x2");
        System.out.println(test.stream().collect(Collectors.joining(",")));
    }
}
