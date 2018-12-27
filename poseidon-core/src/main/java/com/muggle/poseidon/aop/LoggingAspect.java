package com.muggle.poseidon.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dzk on 2018/11/16.
 */
@Aspect
//@Configuration
public class LoggingAspect {

    private final static Logger log = LoggerFactory.getLogger("runningTime");

    @Pointcut("@annotation(com.muggle.poseidon.annontation.ElapedTime)")
    public void loggable() {
    }

    /**
     *  方法耗时计算
     * @param joinPoint
     * @throws Throwable
     */
    @Around("loggable()")
    public Object beforeMethodStatistics(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        Long end = System.currentTimeMillis() - start;
        log.info("class :{} -- method : {}-- speed time ----- {} ms",joinPoint.getTarget(),signature.getMethod().getName() ,end);
        return proceed;
    }
}
