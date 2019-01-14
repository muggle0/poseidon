package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.service.PoseidonSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/info/{id}")
    public ResultBean getSignById(@PathVariable String id){
        return  signService.getSignById( id);
    }

    @PostMapping("/insert")
    public ResultBean insertSign(@RequestBody @Validated  PoseidonSign poseidonSign,@NotNull String validata){
        return  signService.insert(poseidonSign,validata);
    }

    @PutMapping("/update")
    public ResultBean updateSign(@Validated PoseidonSign poseidonSign,@NotNull String validata){
        return signService.update(poseidonSign,validata);
    }
    @DeleteMapping("/delete/{id}")
    public ResultBean delete(@PathVariable String id){
        return signService.delete(id);
    }
}
