package com.muggle.poseidon.oa.controller;


import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.oa.OaRole;
import com.muggle.poseidon.service.oa.IOaRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.jar.Attributes;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/poseidon/oa-role")
public class OaRoleController  {
    public String msg;
    {this.msg="";}

    @Autowired
    IOaRoleService oaRoleService;


    public ResultBean<OaRole> addRole(OaRole oaRole){
        OaRole result = oaRoleService.saveOaRole(oaRole);
        return ResultBean.successData(result);
    }
}

