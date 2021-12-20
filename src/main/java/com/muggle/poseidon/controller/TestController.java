package com.muggle.poseidon.controller;

import com.github.pagehelper.Page;
import com.muggle.poseidon.annotation.InterfaceAction;
import com.muggle.poseidon.base.ResultBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@RestController
public class TestController {
    @PostMapping("/test.json")
    @InterfaceAction
    public ResultBean test(@RequestBody Map<String,String> map){
        System.out.println(map);
        return ResultBean.success();
    }
}
