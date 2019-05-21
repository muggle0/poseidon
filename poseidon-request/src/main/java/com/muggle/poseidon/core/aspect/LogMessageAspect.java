package com.muggle.poseidon.core.aspect;

import com.muggle.poseidon.manage.UserInfoManager;
import com.muggle.poseidon.manager.UserInfoManagerImpl;
import com.muggle.poseidon.utils.RequestUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @program: hiram_erp
 * @description: 日志信息切面
 * @author: muggle
 * @create: 2019-02-21
 **/
@Aspect
@Component
public class LogMessageAspect {

    @Autowired
    UserInfoManager userInfoManager;

    private final static Logger logger = LoggerFactory.getLogger("requestLog");
//    private final static Logger timeLog = LoggerFactory.getLogger(LogMessageAspect.class);
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    @Pointcut("execution(public * com.muggle.poseidon.controller.*.*(..))")
    public void webLog() {}

    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssss");
       /* // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        // 打印请求 url
        // 请求id
        Long userId=null;
        if (user!=null){
            userId=user.getUserInfo().getUserId();
        }
        logger.info("URL : {}, 登录id: {} ,HTTP Method: {},ip :{},Request Args : {}", request.getRequestURL().toString(),userId, request.getMethod(),request.getRemoteAddr());
*/    }

    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {


    }

    /**
     * 环绕
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        // 打印出参
//        logger.info("Response Args  : {},", JSONObject.toJSONString(result),new Date());
        // 执行耗时
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        String requestURL = request.getRequestURL().toString();
        if (requestURL.contains("/sys/log_info/")){
            return result;
        }
        // 打印请求相关参数
        // 打印请求 url
        // 请求id
        String userId = userInfoManager.getUserInfo().getId();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String remoteAddr = RequestUtils.getIpAddr(request);
        Object[] args = joinPoint.getArgs();
//        List<Object> objects=new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<args.length;i++){
            if (args[i] instanceof Serializable||args[i] instanceof Number ||args[i] instanceof String){
                stringBuilder.append( args[i].toString());
//                objects.add(args[i]);
            }
        }
        logger.info("{\"startTime\":\"{}\",\"url\":\"{}\",\"userId\":\"{}\" ,\"httpMethod\":\"{}\",\"ip\":\"{}\",\"requestArgs\":\"{}\",\"status\":{}}",startTime,url,userId,method,remoteAddr,stringBuilder.toString(),response.getStatus());
        return result;
    }


}
