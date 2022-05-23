package com.sofia.poseidon.controller;


import com.muggle.poseidon.base.BaseController;
import com.muggle.poseidon.base.ResultBean;
import com.sofia.poseidon.entity.dto.SysMenuDTO;
import com.sofia.poseidon.entity.pojo.SysMenu;
import com.sofia.poseidon.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/system/menu")
@Slf4j
public class SysMenuController extends BaseController {
	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 根据id 获取menu
	 * @param id
	 * @return
	 */
	@GetMapping("/info/{id}")
	public ResultBean<SysMenuDTO> info(@PathVariable(name = "id") Long id) {
		SysMenuDTO menuById = sysMenuService.getMenuById(id);
        log.info("根据ID获取菜单信息:{}", menuById);
        return ResultBean.successData(menuById);
	}

	/**
	 * 获取menu树
	 * @return
	 */
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('sys:menu:list')")
	public ResultBean<List<SysMenuDTO>> list(Principal principal) {
        List<SysMenuDTO> menuTree = sysMenuService.getMenuTree(principal.getName());
        return ResultBean.successData(menuTree);
	}

	/**
	 * 保存按钮
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/save")
	public ResultBean<SysMenuDTO> save(@Validated @RequestBody SysMenuDTO sysMenu) {
        int row = sysMenuService.insertMenu(sysMenu);
        return ResultBean.successData(sysMenu);
	}

	/**
	 * 更新按钮
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/update")
	public ResultBean<SysMenu> update(@Validated @RequestBody SysMenu sysMenu) {
        int row = sysMenuService.updateMenu(sysMenu);
        return ResultBean.successData(sysMenu);
	}

	/**
	 * 删除按钮
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	public ResultBean delete(@PathVariable("id") String id) {
		sysMenuService.deleteByid(id);
		return ResultBean.success();
	}
}
