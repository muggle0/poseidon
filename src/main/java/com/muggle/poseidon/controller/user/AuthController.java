package com.muggle.poseidon.controller.user;

import com.muggle.poseidon.base.ResultBean;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {



	/**
	 * 获取验证码,通过key存入redis
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/api/captcha")
	public ResultBean<Map<String,String>> captcha() throws IOException {

	}

	/**
	 * 获取用户信息接口
	 * @param principal
	 * @return
	 */
	@GetMapping("/sys/userInfo")
	public ResultBean<SysUserVO> userInfo(Principal principal) {
        SysUser userInfo = sysUserServiceImpl.getUserInfo(principal.getName());
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtils.copyProperties(userInfo, sysUserVO);
        return ResultBean.successData(sysUserVO);
	}
}
