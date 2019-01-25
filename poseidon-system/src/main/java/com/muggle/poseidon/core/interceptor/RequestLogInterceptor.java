package com.muggle.poseidon.core.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.model.PoseidonBlackList;
import com.muggle.poseidon.service.PoseidonBlackListService;
import com.muggle.poseidon.manager.UserInfoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Map;
import  com.muggle.poseidon.core.properties.PoseidonProperties;
import com.muggle.poseidon.utils.RequestUtils;

/**
 * @Description: 请求日志记录
 * @Param:
 * @return:
 * @Author: muggle
 * @Date:
 */
public class RequestLogInterceptor implements HandlerInterceptor {
    private final static Logger log = LoggerFactory.getLogger("requestLog");
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    PoseidonBlackListService blackListService;

    public RequestLogInterceptor(PoseidonBlackListService blackListService) {
        this.blackListService = blackListService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ipAddr = RequestUtils.getIpAddr(request);
         String id = UserInfoManager.getUserId();
        PoseidonBlackList byUserId = new PoseidonBlackList();
        PoseidonBlackList byIpAddr = new PoseidonBlackList();
        byUserId.setStatus(1).setUserId(id);
        byIpAddr.setStatus(1).setRemark(ipAddr);
        long userId =0;
//        todo redis 缓存
        if (!id.equals("-1")){
            userId =blackListService.count(byUserId);
        }
        long ip = blackListService.count(byIpAddr);
        if (ip>0||userId>0){
           throw new PoseidonException("黑名单用户",PoseidonProperties.BLACK_LIST_USER);
        }
            long beginTime = System.currentTimeMillis();
        // 线程绑定变量（该数据只有当前请求的线程可见）
        threadLocal.set(beginTime);
        log.info("请求开始时间:{}", new SimpleDateFormat("HH:mm:ss.SSS").format(beginTime));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long beginTime = threadLocal.get();
        if (beginTime == null) {
//            请求转发直接return
            return;
        }
        long endTime = System.currentTimeMillis();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String requestMap = JSONObject.toJSONString(parameterMap);
        String method = request.getMethod();
        log.info("请求时长:{}ms --URI:{} --请求者ip地址:{} --请求参数:{}", endTime - beginTime, method + ":" + request.getRequestURI(), RequestUtils.getIpAddr(request), requestMap);
        threadLocal.remove();
    }

}
