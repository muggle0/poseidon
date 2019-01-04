package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.vo.UserVO;
import com.muggle.poseidon.service.PoseidonUserdetailService;
import com.muggle.poseidon.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：muggle
 * @date ：Created in 2019/1/1
 * @description：用户管理类
 * @version:
 */
@RestController
@RequestMapping("/poseidon/user")
public class UserController {
    @Autowired
    PoseidonUserdetailService userService;

    @GetMapping("/role_user")
    public ResultBean getUsers(String roleId){
        return userService.getUsersByRoleId(roleId);
    }

    @GetMapping("/my_info")
    public ResultBean userInfo(String roleId){
        PoseidonUserDetail user = UserInfoService.getUser();
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return ResultBean.getInstance(userVO);
    }


    @GetMapping("/info/{id}")
    public ResultBean getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public ResultBean update( @Validated UserVO user,String oldPassword,String newPassword ){
        return userService.update(user,oldPassword,newPassword);
    }

    @DeleteMapping("/delete")
    public ResultBean delete( ){
        return userService.delete();
    }

}
