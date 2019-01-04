package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.service.PoseidonGrantedAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2019-01-04 16:40
 **/
@RestController
@RequestMapping("/admin/oauth")
public class OauthController {
    @Autowired
    PoseidonGrantedAuthorityService poseidonGrantedAuthorityService;

    @GetMapping("/authority")
    public ResultBean getAuthority(PoseidonGrantedAuthority authority){
        return poseidonGrantedAuthorityService.findAll(authority);
    }

    @PutMapping("/authority/update")
    public ResultBean update(PoseidonGrantedAuthority authority){
        return poseidonGrantedAuthorityService.update(authority);
    }

    @PostMapping("/authority/insert_batch")
    public ResultBean insert(List<PoseidonGrantedAuthority> authorityList){
        return poseidonGrantedAuthorityService.insert(authorityList);
    }

    @DeleteMapping("/authority/{id}")
    public ResultBean delete(@PathVariable String id){
        return poseidonGrantedAuthorityService.delete(id);
    }


}
