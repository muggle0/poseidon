package com.sofia.poseidon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.base.exception.SimplePoseidonException;
import com.sofia.poseidon.entity.dto.SysMenuDTO;
import com.sofia.poseidon.entity.pojo.SysMenu;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.entity.vo.SysUserVO;
import com.sofia.poseidon.manager.UserInfoManager;
import com.sofia.poseidon.mapper.SysMenuMapper;
import com.sofia.poseidon.mapper.SysRoleMapper;
import com.sofia.poseidon.mapper.SysUserMapper;
import com.sofia.poseidon.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private UserInfoManager userInfoManager;

    @Override
    public SysUserVO getUserMenu(String name) {
        List<SysMenu> userMenuList = sysMenuMapper.getUserMenu(name);
        List<String> authoritys = getRoleCode(name);
        for (SysMenu sysMenu : userMenuList) {
            authoritys.add(sysMenu.getPermission());
        }
        SysUser sysUser = (SysUser) userInfoManager.loadUserByUsername(name);
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

    @Override
    public SysMenuDTO getMenuById(Long id) {
        SysMenu sysMenu=sysMenuMapper.getMenuById( id);
        final SysMenuDTO sysMenuDTO = new SysMenuDTO();
        BeanUtils.copyProperties(sysMenu,sysMenuDTO);
        return sysMenuDTO;
    }

    @Override
    public List<SysMenuDTO> getMenuTree(String username) {
        final UserDetails userDetails = userInfoManager.loadUserByUsername(username);
        if (userDetails==null||!userDetails.isEnabled()){
            throw new SimplePoseidonException("账号已冻结");
        }
//        final List<SysMenu> userMenus = sysMenuMapper.getUserMenu(username);
        final QueryWrapper<SysMenu> query = new QueryWrapper<>();
        query.lambda().in(SysMenu::getType,0,1);
        final List<SysMenu> userMenus = sysMenuMapper.selectList(query);
        if (CollectionUtils.isEmpty(userMenus)){
            return Collections.emptyList();
        }
        final List<SysMenuDTO> menuDTOS = covertMenu(userMenus);
        return menuDTOS;
    }

    @Override
    public int insertMenu(SysMenuDTO sysMenu) {
        return 0;
    }

    @Override
    public void deleteByid(Long id) {
        sysMenuMapper.deleteById(id);
        final QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysMenu::getParentId,id);
        final List<SysMenu> sysMenus = sysMenuMapper.selectList(queryWrapper);
        for (SysMenu sysMenu : sysMenus) {
            deleteByid(sysMenu.getId());
        }
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
    private List<SysMenuDTO> covertMenu(List<SysMenu> menus) {
        final List<SysMenuDTO> collect = menus.stream().filter(bean-> bean.getType()==0||bean.getType()==1).map(bean -> {
                final SysMenuDTO sysMenuDTO = new SysMenuDTO();
                BeanUtils.copyProperties(bean, sysMenuDTO);
                sysMenuDTO.setChildren(new ArrayList<>());
                return sysMenuDTO;
            }).collect(Collectors.toList());
        List<SysMenuDTO> result =new ArrayList<>();
        final Map<Long, SysMenuDTO> maps = collect.stream().collect(Collectors.toMap(SysMenuDTO::getId, Function.identity(), (v1, v2) -> v1));
        for (SysMenuDTO sysMenuDTO : collect) {
                if (sysMenuDTO.getParentId()==null||sysMenuDTO.getParentId()==0L){
                result.add(sysMenuDTO);
                continue;
            }
            setChild(maps,sysMenuDTO);
        }
        return result;
    }

    private SysMenuDTO setChild(Map<Long, SysMenuDTO> collect, SysMenuDTO menu) {
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
