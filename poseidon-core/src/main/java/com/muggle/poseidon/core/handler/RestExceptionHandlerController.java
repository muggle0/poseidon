package com.muggle.poseidon.core.handler;



import com.muggle.poseidon.base.PoseidonException;
import com.muggle.poseidon.base.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: poseidon
 * @description: 异常统一处理类（不开启，使用ControllerAOP,也可切换过来）
 * @author: muggle
 * @create: 2018-09-06 16:22
 **/
@RestControllerAdvice
@Slf4j
public class RestExceptionHandlerController {
    @ExceptionHandler(value = {PoseidonException.class})
    public ResultBean PoseidonExceptionHandler(PoseidonException e, HttpServletRequest req){
        return new ResultBean().setMsg(e.getMsg()).setCode(e.getCode());
    }
    @ExceptionHandler(value = {Exception.class})
    public ResultBean exceptionHandler(Exception e, HttpServletRequest req){
        log.error("系统异常："+req.getMethod()+req.getRequestURI(),e);
        return new ResultBean().setMsg("系统异常，请联系管理员").setCode("500");
    }
}
