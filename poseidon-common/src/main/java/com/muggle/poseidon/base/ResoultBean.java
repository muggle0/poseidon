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
public class ResoultBean {
    private String code;
    private String msg;
    private Object date;

    public ResoultBean success(String msg,Object date){
        ResoultBean resoultBean = new ResoultBean()
                .setCode(BeanProperties.SUCCESS_CODE).setDate(date).setMsg(msg);
        return resoultBean;
    }

    public ResoultBean error(String msg){
        ResoultBean resoultBean = new ResoultBean().setCode(BeanProperties.ERROR_CODE).setMsg(msg);
        return resoultBean;
    }
    public ResoultBean success(String msg){
        ResoultBean resoultBean = new ResoultBean().setCode(BeanProperties.SUCCESS_CODE).setMsg(msg);
        return resoultBean;
    }
}
