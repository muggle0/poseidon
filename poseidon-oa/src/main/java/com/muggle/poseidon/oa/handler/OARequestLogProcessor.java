package com.muggle.poseidon.oa.handler;

import com.muggle.poseidon.handler.security.RequestLogProcessor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/10
 **/
@Component
public class OARequestLogProcessor implements RequestLogProcessor {
    @Override
    public void recordBefore(HttpServletRequest httpServletRequest, Object[] objects) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void recordAfterReturning(Object o, Object[] objects) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
    }
}
