package com.muggle.poseidon.controller.user;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcat.common.lang.ResultBean;
import com.lcat.common.pagination.PageUtils;
import com.lcat.entity.SysUser;
import com.lcat.entity.dto.PassDTO;
import com.lcat.service.SysUserRoleService;
import com.lcat.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/sys/user")
@Slf4j
public class SysUserController extends BaseController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
    private SysUserService sysUserService;
	@Autowired
    private SysUserRoleService sysUserRoleService;

	/**
	 * 根据用户id获取用户信息
	 * @param id
	 * @return
	 */
	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('sys:user:list')")
	public ResultBean info(@PathVariable("id") Long id) {
        SysUser userInfoById = sysUserService.getUserInfoById(id);
        return ResultBean.successData(userInfoById);
	}

    /**
     * 获取用户权限
     * @param username
     * @param current
     * @param size
     * @return
     */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('sys:user:list')")
    public ResultBean list(String username, Long current, Long size) {
	    //不搜索走这个
        if (username == null) {
            List<SysUser> allUserInfo = sysUserService.getAllUserInfo(current, size);
            if (current == null) {
                return ResultBean.successData(allUserInfo);
            }
            log.info("用户信息列表1：{}", allUserInfo);
            PageUtils pageUtils = new PageUtils();
            Page<SysUser> userPage = pageUtils.doPages(current, size, true, allUserInfo);
            if (userPage == null) {
                log.info("用户权限为空");
                return ResultBean.error("用户权限为空！！");
            }
            log.info("用户信息列表2: {}",userPage.getRecords());
            return ResultBean.successData(userPage);
        }
        //搜索走这个
        List<SysUser> userInfoList = sysUserService.getUserInfoByName(username, current, size);
        if (current == null) {
            return ResultBean.successData(userInfoList);
        }
        log.info("用户信息列表1：{}", userInfoList);
        PageUtils pageUtils = new PageUtils();
        Page<SysUser> userPage = pageUtils.doPages(current, size, true, userInfoList);
        if (userPage == null) {
            log.info("用户权限为空");
            return ResultBean.error("用户权限为空！！");
        }
        log.info("用户信息列表2: {}",userPage.getRecords());
        return ResultBean.successData(userPage);
    }

	/**
	 * 保存用户信息
	 * @param sysUser
	 * @return
	 */
	@PostMapping("/save")
	@PreAuthorize("hasAuthority('sys:user:save')")
	public ResultBean save(@Validated @RequestBody SysUser sysUser) {
        int row = sysUserService.insertUserInfo(sysUser);
        log.info("新增用户成功，新增条数:{},用户信息:{}",row, sysUser);
        return ResultBean.successData(sysUser);
	}

	/**
	 * 更新用户信息
	 * @param sysUser
	 * @return
	 */
	@PostMapping("/update")
	@PreAuthorize("hasAuthority('sys:user:update')")
	public ResultBean update(@Validated @RequestBody SysUser sysUser) {
        int row = sysUserService.updateUserInfoById(sysUser);
        if (row > 0) {
            log.info("更新用户成功, 用户信息:{}",sysUser);
            return ResultBean.successData(sysUser);
        }
        return ResultBean.error("修改失败");
	}

	/**
	 * 删除用户信息
	 * @param ids
	 * @return
	 */
	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('sys:user:delete')")
	public ResultBean delete(@RequestBody Long[] ids) {
        int row = sysUserService.deleteUserByIds(ids);
        if (row > 0) {
            log.info("删除用户数:{}, 用户:{}",row,ids);
            return ResultBean.successData(ids);
        }
        return ResultBean.error("删除用户失败！");
	}

	/**
	 * 更新用户角色
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@PostMapping("/role/{userId}")
	@PreAuthorize("hasAuthority('sys:user:role')")
	public ResultBean rolePerm(@PathVariable("userId") Long userId, @RequestBody Long[] roleIds) {
        int row = sysUserRoleService.updateRoleByUserId(userId, roleIds);
        if (row > 0) {
            log.info("更新成功，更新后角色为：{}", roleIds);
            return ResultBean.successData(roleIds);
        }
        return ResultBean.error("更新用户角色失败");
	}

	/**
	 * 重置密码
	 * @param userId
	 * @return
	 */
	@PostMapping("/repass")
	@PreAuthorize("hasAuthority('sys:user:repass')")
	public ResultBean repass(@RequestBody Long userId) {
        int row = sysUserService.repass(userId);
        if (row < 0) {
            return ResultBean.error("重置密码失败");
        }
        log.info("重置密码成功，用户ID:{}", userId);
        return ResultBean.successData(userId);
	}

	/**
	 * 更新密码
	 * @param passDto
	 * @return
	 */
	@PostMapping("/updatePass")
	public ResultBean updatePass(@Validated @RequestBody PassDTO passDto) {
        int row = sysUserService.updatePass(passDto);
        if (row <= 0) {
            ResultBean.error("更新密码失败");
        }
        return ResultBean.success();
	}
}
