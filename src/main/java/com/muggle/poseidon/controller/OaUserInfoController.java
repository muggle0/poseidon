package com.muggle.poseidon.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.muggle.poseidon.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author muggle
 * @since 2020-11-11
 */
@RestController
@RequestMapping("/poseidon/oa-user-info")
public class OaUserInfoController extends BaseController {
    @GetMapping("/xx")
    public String test(){
        return ">";
    }

}