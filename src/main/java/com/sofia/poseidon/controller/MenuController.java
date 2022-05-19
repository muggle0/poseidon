package com.sofia.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.sofia.poseidon.entity.vo.SysUserVO;
import com.sofia.poseidon.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Description
 * Date 2022/5/12
 * Created by muggle
 */
@RequestMapping("/system")
@RestController
public class MenuController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 获取当前用户的菜单和权限信息
     * @param principal
     * @return
     */
    @GetMapping("/user/UserMenu")
    public ResultBean<SysUserVO> getUserMenu(Principal principal) {
        SysUserVO userMenu = sysMenuService.getUserMenu(principal.getName());
        return ResultBean.successData(userMenu);
    }

//    @PostMapping("/")
}
