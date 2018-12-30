package com.muggle.poseidon.base;

import com.muggle.poseidon.core.properties.BeanProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-24 19:51
 **/
@Data
@Accessors(chain = true)
public class ResultBean {
    private String code;
    private String msg;
    private Object date;

    public ResultBean success(String msg, Object date){
        ResultBean resultBean = new ResultBean()
                .setCode(BeanProperties.SUCCESS_CODE).setDate(date).setMsg(msg);
        return resultBean;
    }

    public ResultBean error(String msg){
        ResultBean resultBean = new ResultBean().setCode(BeanProperties.ERROR_CODE).setMsg(msg);
        return resultBean;
    }
    public ResultBean success(String msg){
        ResultBean resultBean = new ResultBean().setCode(BeanProperties.SUCCESS_CODE).setMsg(msg);
        return resultBean;
    }
}
