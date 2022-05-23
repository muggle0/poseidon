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
import java.util.Date;
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
    private UserInfoManager userInfoManager;

    @Override
    public SysUserVO getUserMenu(String name) {
        return  userInfoManager.getUserMenu(name);
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
        final QueryWrapper<SysMenu> query = new QueryWrapper<>();
        query.lambda().in(SysMenu::getType,0,1);
        final List<SysMenu> userMenus = sysMenuMapper.selectList(query);
        if (CollectionUtils.isEmpty(userMenus)){
            return Collections.emptyList();
        }
        final List<SysMenuDTO> menuDTOS = userInfoManager.covertMenu(userMenus);
        return menuDTOS;
    }

    @Override
    public int insertMenu(SysMenuDTO sysMenu) {
        final QueryWrapper<SysMenu> query = new QueryWrapper<>();
        query.lambda().eq(SysMenu::getName,sysMenu.getName()).or().eq(SysMenu::getPermission,sysMenu.getPermission());
        final SysMenu dbMenu = sysMenuMapper.selectOne(query);
        if (dbMenu!=null){
            throw new SimplePoseidonException("菜单编码重复");
        }
        final SysMenu save = new SysMenu();
        BeanUtils.copyProperties(sysMenu,save);
        save.setCreated(new Date());
        save.setUpdated(new Date());
        save.setTitle(sysMenu.getName());
        save.setEnabled(1);
        return sysMenuMapper.insert(save);
    }

    @Override
    public void deleteByid(String id) {
        final int i = sysMenuMapper.deleteById(id);
        final QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysMenu::getParentId,id);
        final List<SysMenu> sysMenus = sysMenuMapper.selectList(queryWrapper);
        for (SysMenu sysMenu : sysMenus) {
            deleteByid(sysMenu.getId());
        }
    }

    @Override
    public int updateMenu(SysMenu sysMenu) {
        final QueryWrapper<SysMenu> query = new QueryWrapper<>();
        query.lambda().eq(SysMenu::getName,sysMenu.getName()).or().eq(SysMenu::getPermission,sysMenu.getPermission());
        final SysMenu dbMenu = sysMenuMapper.selectOne(query);
        if (dbMenu!=null&&!sysMenu.getId().equals(dbMenu.getId())){
            throw new SimplePoseidonException("菜单编码重复");
        }
        return  sysMenuMapper.updateById(sysMenu);
    }


}
