package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.service.PoseidonUserdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/1
 * @description：用户管理类
 * @version:
 */
@RestController
public class UserController {
    @Autowired
    PoseidonUserdetailService userService;


}
