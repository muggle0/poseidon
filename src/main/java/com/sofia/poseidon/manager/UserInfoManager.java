package com.sofia.poseidon.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sofia.poseidon.entity.dto.SysMenuDTO;
import com.sofia.poseidon.entity.pojo.SysMenu;
import com.sofia.poseidon.entity.pojo.SysRole;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.entity.vo.SysUserVO;
import com.sofia.poseidon.mapper.SysMenuMapper;
import com.sofia.poseidon.mapper.SysRoleMapper;
import com.sofia.poseidon.mapper.SysUserMapper;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    public SysUserVO getUserMenu(String name) {
        List<SysMenu> userMenuList = menuMapper.getUserMenu(name);
        List<String> authoritys = getRoleCode(name);
        for (SysMenu sysMenu : userMenuList) {
            authoritys.add(sysMenu.getPermission());
        }
        SysUser sysUser = (SysUser) this.loadUserByUsername(name);
        SysUserVO userVO = new SysUserVO();
        userVO.setAuthoritys(authoritys);
        final List<SysMenuDTO> sysMenuDTOS = covertMenu(userMenuList);
        userVO.setMenus(sysMenuDTOS);
        userVO.setId(sysUser.getId());
        userVO.setUsername(sysUser.getUsername());
        userVO.setAvatar(sysUser.getAvatar());
        userVO.setCreated(LocalDateTime.now());
        return  userVO;
    }

    private List<String> getRoleCode(String username) {
        List<String> roleList = sysRoleMapper.getRoleCode(username);
        List<String> list = roleList.stream().map(r -> "ROLE_" + r).collect(Collectors.toList());
        return list;
    }

    /**
     * 获取父级菜单--用户管理
     * @param menus
     * @return
     */
    public List<SysMenuDTO> covertMenu(List<SysMenu> menus) {
        final List<SysMenuDTO> collect = menus.stream().filter(bean-> bean.getType()==0||bean.getType()==1).map(bean -> {
            final SysMenuDTO sysMenuDTO = new SysMenuDTO();
            BeanUtils.copyProperties(bean, sysMenuDTO);
            sysMenuDTO.setTitle(bean.getTitle());
            sysMenuDTO.setChildren(new ArrayList<>());
            return sysMenuDTO;
        }).collect(Collectors.toList());
        List<SysMenuDTO> result =new ArrayList<>();
        final Map<String, SysMenuDTO> maps = collect.stream().collect(Collectors.toMap(SysMenuDTO::getId, Function.identity(), (v1, v2) -> v1));
        for (SysMenuDTO sysMenuDTO : collect) {
            if (sysMenuDTO.getParentId()==null||sysMenuDTO.getParentId().equals("0")){
                result.add(sysMenuDTO);
                continue;
            }
            setChild(maps,sysMenuDTO);
        }
        return result;
    }

    private SysMenuDTO setChild(Map<String, SysMenuDTO> collect, SysMenuDTO menu) {
        SysMenuDTO sysMenuDTO = collect.get(menu.getParentId());
        if (sysMenuDTO.getChildren()==null) {
            List<SysMenuDTO> childrens =new ArrayList<>();
            childrens.add(sysMenuDTO);
            sysMenuDTO.setChildren(childrens);
        }else {
            sysMenuDTO.getChildren().add(menu);
        }
        return sysMenuDTO;
    }
}
