package com.muggle.poseidon.interceptor;

import com.alibaba.fastjson.JSON;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.util.UserInfoUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/2
 **/
public class UserInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDetails userInfo = UserInfoUtils.getUserInfo();
        if (userInfo==null) {
            return true;
        }
        boolean bool = userInfo.isCredentialsNonExpired();
        if (!bool){
            ResultBean<Object> error = ResultBean.error("未完善用户信息，请先完善用户信息");
            response.getOutputStream().print( JSON.toJSONString(error));
        }
        return true;
    }
}
