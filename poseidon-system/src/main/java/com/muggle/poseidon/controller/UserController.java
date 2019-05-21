package com.muggle.poseidon.controller;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.PoseidonUserDetail;
import com.muggle.poseidon.entity.UserInfoDTO;
import com.muggle.poseidon.entity.vo.UserVO;
import com.muggle.poseidon.manage.UserInfoManager;
import com.muggle.poseidon.service.PoseidonUserdetailService;
import com.muggle.poseidon.manager.UserInfoManagerImpl;
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
    @Autowired
    UserInfoManager userInfoManager;

    @GetMapping("/role_user")
    public ResultBean getUsers(String roleId){
        return userService.getUsersByRoleId(roleId);
    }

    @GetMapping("/my_info")
    public ResultBean userInfo(){
        UserInfoDTO userInfo = userInfoManager.getUserInfo();

        return ResultBean.getInstance(userInfo);
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
