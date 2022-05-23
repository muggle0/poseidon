package com.sofia.poseidon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.muggle.poseidon.base.ResultBean;
import com.sofia.poseidon.entity.vo.SysRoleVO;
import com.sofia.poseidon.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description
 * Date 2022/5/23
 * Created by muggle
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    private SysRoleService  sysRoleService;

    @GetMapping("/list")
    public ResultBean<IPage<SysRoleVO>> list(String name, Long current, Long size) {
        final IPage<SysRoleVO> allRole = sysRoleService.getAllRole(current, size);
        return ResultBean.successData(allRole);
    }
}