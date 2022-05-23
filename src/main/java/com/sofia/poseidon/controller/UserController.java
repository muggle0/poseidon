package com.sofia.poseidon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.util.IStringUtils;
import com.sofia.poseidon.entity.vo.SysUserVO;
import com.sofia.poseidon.service.SysUserService;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * Date 2021/11/4
 * Created by muggle
 */
@RestController
public class UserController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/user/encode")
    @PreAuthorize("hasAuthority('sys:menu:list')")
    public String getEncode(String code){
        return passwordEncoder.encode(code);
    }



    /**
     * 获取验证码,通过key存入redis
     * @return
     * @throws IOException
     */
    @GetMapping("/user/captcha.json")
    public ResultBean<Map<String,String>> captcha() throws IOException {
        String key = UUID.randomUUID().toString();
        final String code = IStringUtils.getCode(5);
        final RMap<Object, Object> captcha = redissonClient.getMap("poseidon:captcha");
        captcha.put(key,code);
        captcha.expire(5, TimeUnit.MINUTES);
        Map<String, String> result=new HashMap<>();
        result.put("code",code);
        result.put("key",key);
        return ResultBean.successData(result);
    }

    @GetMapping("/user/userInfo")
    public ResultBean<SysUserVO> userInfo(Principal principal) {
        SysUserVO sysUserVO=sysUserService.getUserInfo(principal.getName());
        return ResultBean.successData(sysUserVO);
    }

    @GetMapping("/system/user/list")
    public ResultBean<IPage<SysUserVO>> userInfo(String username, Long current, Long size) {
        if (current==null){
            current=1L;
        }
        if (size==null){
            size=10L;
        }
        final IPage<SysUserVO> userList = sysUserService.getUserList(username, current, size);
        return ResultBean.successData(userList);
    }

}
