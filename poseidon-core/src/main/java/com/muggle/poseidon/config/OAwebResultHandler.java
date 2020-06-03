package com.muggle.poseidon.config;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.handler.WebResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/2
 **/
@RestControllerAdvice
@Configuration
public class OAwebResultHandler extends WebResultHandler {
    private static final Logger log = LoggerFactory.getLogger(OAwebResultHandler.class);
    @ExceptionHandler({ConstraintViolationException.class})
    public ResultBean methodArgumentNotValidException(ConstraintViolationException e, HttpServletRequest req) {
        log.error("参数未通过校验", e);
        ResultBean error = ResultBean.error(e.getConstraintViolations().iterator().next().getMessage());
        return error;
    }
}
