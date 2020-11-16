package com.muggle.poseidon.controller;


import static com.muggle.poseidon.base.ResultBean.error;
import static com.muggle.poseidon.base.ResultBean.success;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.form.AuthorityForm;
import com.muggle.poseidon.entity.pojo.OaAuthority;
import com.muggle.poseidon.service.IOaAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.muggle.poseidon.base.BaseController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author muggle
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/poseidon/oa-authority")
public class OaAuthorityController extends BaseController {

    @Autowired
    IOaAuthorityService authorityService;

    @PostMapping(value = "/save",produces ={"application/json"} )
    public ResultBean addAuthority(@Validated @RequestBody OaAuthority authority){
        Boolean result=authorityService.addAuthority(authority);
        return result?success():error("新增权限失败");
    }

    @PostMapping(value = "/add-role-auth",produces ={"application/json"} )
    public ResultBean addRoleAuth(@RequestBody AuthorityForm authorityForm){
        Boolean result=authorityService.addRoleAuth(authorityForm);
        return result?success():error("新增权限失败");
    }



}
