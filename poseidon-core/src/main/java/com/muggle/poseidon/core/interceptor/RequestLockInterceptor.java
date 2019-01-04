package com.muggle.poseidon.core.interceptor;

import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.service.RedisLock;
import com.muggle.poseidon.service.impl.RedislockImpl;
import com.muggle.poseidon.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.muggle.poseidon.core.properties.PoseidonProperties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @program: hiram_erp
 * @description: 防止表单重复提交锁
 * @author: muggle
 * @create: 2018-12-06 11:02
 **/
@Slf4j
public class RequestLockInterceptor implements HandlerInterceptor {
    RedisLock redisTool;
    private int expireTime;

    public RequestLockInterceptor(int expireTime, RedislockImpl redisTool) {
        this.expireTime = expireTime;
        this.redisTool = redisTool;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("access_token");
        String ipAddr = RequestUtils.getIpAddr(request);
        String lockKey = request.getRequestURI() + "_" + ipAddr + "_" + token;

        /*if("get".equalsIgnoreCase(request.getMethod())){
            return true;
        }*/
        boolean lock = redisTool.lock(lockKey, ipAddr, expireTime);
        if (!lock) {//
            log.error("拦截表单重复提交");
//            throw new PoseidonException("请求太频繁",PoseidonProperties.TOO_NUMBER_REQUEST);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write("{\"code\":\"500\",\"msg\":\"请求太频繁\"}");
            writer.close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String lockKey = request.getRequestURI() + "_" + RequestUtils.getIpAddr(request);
//        redisTool.unlock(lockKey,getIpAddr(request));
    }


}
