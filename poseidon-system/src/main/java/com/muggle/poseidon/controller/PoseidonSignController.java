package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.service.PoseidonSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/3
 * @description：
 * @version:
 */
@RestController
public class PoseidonSignController {
    @Autowired
    PoseidonSignService signService;
    @GetMapping("/sign/info")
    public ResultBean getSigns(){
        return  signService.getSigns();
    }
}
