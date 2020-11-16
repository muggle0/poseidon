package com.muggle.poseidon.controller;


import static com.muggle.poseidon.base.ResultBean.successData;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.vo.OaUserVO;
import com.muggle.poseidon.service.IOaUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    IOaUserInfoService oaUserInfoService;

    @GetMapping("/xx")
    public String test(){
        return ">";
    }

    @PostMapping("/save")
    public ResultBean<OaUserVO> save(OaUserVO oaUserVO){
        OaUserVO save = oaUserInfoService.save(oaUserVO);
        return successData(save);
    }

}
