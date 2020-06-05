package com.muggle.poseidon.base.query;

import com.github.pagehelper.PageHelper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/5
 **/
@Data
public  abstract class BaseNormalQuery {

    private List<String> orderBy;

    private List<String> groupBy;

    private Map<String,Operator> operatorMap;

    private Sort sort=Sort.DESC;

    private int startPage=1;

    private int pageSize=10;


    public void init(){
        PageHelper.startPage(startPage,pageSize);
        String join = String.join(",", orderBy);
        PageHelper.orderBy(join+" "+sort);
    }

    public enum Sort{
        DESC,ASC
    }

    public enum  Operator{

    }

}
