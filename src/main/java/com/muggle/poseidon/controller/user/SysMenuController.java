package com.muggle.poseidon.controller.user;


import com.lcat.common.lang.ResultBean;
import com.lcat.entity.SysMenu;
import com.lcat.entity.vo.SysUserVO;
import com.lcat.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/sys/menu")
@Slf4j
public class SysMenuController extends BaseController {
	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 获取当前用户的菜单和权限信息
	 * @param principal
	 * @return
	 */
	@GetMapping("/nav")
	public ResultBean<SysUserVO> nav(Principal principal) {
        SysUserVO userMenu = sysMenuService.getUserMenu(principal.getName());
        return ResultBean.successData(userMenu);
	}

	/**
	 * 根据id 获取menu
	 * @param id
	 * @return
	 */
	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('sys:menu:list')")
	public ResultBean<SysMenu> info(@PathVariable(name = "id") Long id) {
        SysMenu menuById = sysMenuService.getMenuById(id);
        log.info("根据ID获取菜单信息:{}", menuById);
        return ResultBean.successData(menuById);
	}

	/**
	 * 获取menu树
	 * @return
	 */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('sys:menu:list')")
	public ResultBean<List<SysMenu>> list(Principal principal) {
        List<SysMenu> menuTree = sysMenuService.getMenuTree(principal.getName());
        return ResultBean.successData(menuTree);
	}

	/**
	 * 保存按钮
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/save")
	@PreAuthorize("hasAuthority('sys:menu:save')")
	public ResultBean<SysMenu> save(@Validated @RequestBody SysMenu sysMenu) {
        int row = sysMenuService.insertMenu(sysMenu);
        log.info("新增{}条菜单信息, 菜单信息：{}", row, sysMenu);
        return ResultBean.successData(sysMenu);
	}

	/**
	 * 更新按钮
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/update")
	@PreAuthorize("hasAuthority('sys:menu:update')")
	public ResultBean<SysMenu> update(@Validated @RequestBody SysMenu sysMenu) {
        int row = sysMenuService.updateMenu(sysMenu);
        log.info("更新{}条菜单数据，菜单信息：{}", row, sysMenu);
        return ResultBean.successData(sysMenu);
	}

	/**
	 * 删除按钮
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('sys:menu:delete')")
	public ResultBean delete(@PathVariable("id") Long id) {
		return ResultBean.success();
	}
}
