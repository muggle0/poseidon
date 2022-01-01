package com.muggle.poseidon.controller.user;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcat.common.lang.ResultBean;
import com.lcat.common.pagination.PageUtils;
import com.lcat.entity.SysRole;
import com.lcat.service.SysRoleMenuService;
import com.lcat.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/role")
@Slf4j
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

	/**
	 * 根据角色id 获取角色
	 * @param id
	 * @return
	 */
	@PreAuthorize("hasAuthority('sys:role:list')")
	@GetMapping("/info/{id}")
	public ResultBean<SysRole> info(@PathVariable("id") Long id) {
        SysRole roles = sysRoleService.getRoleById(id);
        log.info("角色信息：{}", roles);
        return ResultBean.successData(roles);
	}

    /**
     * 根据角色名称查询角色
     * @param current
     * @param size
     * @return
     */
	@PreAuthorize("hasAuthority('sys:role:list')")
	@GetMapping("/list")
    public ResultBean list(String name, Long current, Long size) {
	    if (name == null) {
            List<SysRole> roles = sysRoleService.getAllRole(current, size);
            if (current == null) {
                return ResultBean.successData(roles);
            }
            log.info("角色信息列表1：{}", roles);
            PageUtils pageUtils = new PageUtils();
            Page<SysRole> rolePage = pageUtils.doPages(current, size, true, roles);
            if (rolePage == null) {
                log.info("角色信息为空");
                return ResultBean.error("角色信息为空！！");
            }
            log.info("角色信息列表2: {}",rolePage.getRecords());
            return ResultBean.successData(rolePage);
        }
        List<SysRole> roleList = sysRoleService.getRoleByName(name, current, size);
        if (current == null) {
            return ResultBean.successData(roleList);
        }
        log.info("角色信息列表1：{}", roleList);
        PageUtils pageUtils = new PageUtils();
        Page<SysRole> rolePage = pageUtils.doPages(current, size, true, roleList);
        if (rolePage == null) {
            log.info("角色信息为空");
            return ResultBean.error("角色信息为空！！");
        }
        log.info("角色信息列表2: {}",rolePage.getRecords());
        return ResultBean.successData(rolePage);
    }

	/**
	 * 保存
	 * @param sysRole
	 * @return
	 */
	@PostMapping("/save")
	@PreAuthorize("hasAuthority('sys:role:save')")
	public ResultBean<SysRole> save(@Validated @RequestBody SysRole sysRole) {
        int row = sysRoleService.insertRole(sysRole);
        log.info("新增角色成功，新增条数:{},角色信息:{}",row,sysRole);
        return ResultBean.successData(sysRole);
	}

	/**
	 * 更新
	 * @param sysRole
	 * @return
	 */
	@PostMapping("/update")
	@PreAuthorize("hasAuthority('sys:role:update')")
	public ResultBean<SysRole> update(@Validated @RequestBody SysRole sysRole) {
        int row = sysRoleService.updateRoleById(sysRole);
        if (row > 0) {
            log.info("更新角色信息成功，更新数:{}，角色信息:{}", row, sysRole);
            return ResultBean.successData(sysRole);
        }
        return ResultBean.error("更新失败");
	}

	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('sys:role:delete')")
	public ResultBean info(@RequestBody Long[] ids) {
        int row = sysRoleService.deleteRoleByIds(ids);
        log.info("批量删除角色成功，删除条数:{}，删除用户ID:{}", row, ids);
        return ResultBean.successData(ids);
	}

	/**
	 * 保存角色按钮关联关系
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	@PostMapping("/perm/{roleId}")
	@PreAuthorize("hasAuthority('sys:role:perm')")
	public ResultBean info(@PathVariable("roleId") Long roleId, @RequestBody Long[] menuIds) {
//        int row = sysRoleMenuService.insertOrUpdateMenuId(roleId, menuIds);
        int row = sysRoleMenuService.changeMenuIds(roleId, menuIds);
        log.info("Updated:{},分配权限,权限信息:{}", row, menuIds);
        return ResultBean.successData(menuIds);
	}

}
