package com.sofia.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.sofia.poseidon.entity.dto.SysUserDTO;
import com.sofia.poseidon.entity.pojo.SysUser;
import com.sofia.poseidon.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description
 * Date 2021/11/4
 * Created by muggle
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private SysUserService userService;

    @GetMapping("/encode")
    public String getEncode(String code){
        return passwordEncoder.encode(code);
    }

    @PostMapping("/createUser")
    @PreAuthorize("hasRole('admin')")
    public ResultBean<Long> createUser(@RequestBody @Valid SysUserDTO sysUser){
        final String encode = passwordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(encode);
        userService.createUser(sysUser);
        return ResultBean.successData(sysUser.getId());
    }
}
