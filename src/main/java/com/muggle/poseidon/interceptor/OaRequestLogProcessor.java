package com.muggle.poseidon.interceptor;

import javax.servlet.http.HttpServletRequest;

import com.muggle.poseidon.handler.security.RequestLogProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/17
 **/
@Component
public class OaRequestLogProcessor implements RequestLogProcessor {

    @Override
    public void recordBefore(HttpServletRequest httpServletRequest, Object[] objects) {
        System.out.println(">>>>>>>>>>>");

    }

    @Override
    public void recordAfterReturning(Object o, Object[] objects) {

    }
}
