package com.muggle.poseidon.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/26
 **/
@Controller
public class ViewController {

    @GetMapping("/")
    public String index(){
        return "view/index";
    }



}
