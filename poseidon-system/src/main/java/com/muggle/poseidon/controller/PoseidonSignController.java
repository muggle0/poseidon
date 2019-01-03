package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.service.PoseidonSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/3
 * @description：
 * @version:
 */
@RestController
@RequestMapping("/poseidon/sign")
public class PoseidonSignController {
    @Autowired
    PoseidonSignService signService;


    @GetMapping("/info")
    public ResultBean getSigns(){
        return  signService.getSigns();
    }

    @PostMapping("/insert")
    public ResultBean insertSign(@Validated  PoseidonSign poseidonSign,@NotNull String validata){
        return  signService.insert(poseidonSign,validata);
    }
}
