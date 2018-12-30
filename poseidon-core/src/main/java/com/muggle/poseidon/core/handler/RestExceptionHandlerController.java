package com.muggle.poseidon.core.handler;



import com.muggle.poseidon.base.ResultBean;
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
public class RestExceptionHandlerController {
    @ExceptionHandler(value = {Exception.class})
    public ResultBean exceptionHandler(Exception e, HttpServletRequest req){
        return new ResultBean().setMsg("系统异常");
    }
}
