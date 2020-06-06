package com.muggle.poseidon.oa.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.base.query.BaseNormalQuery;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.query.OaUrlInfoQuery;
import com.muggle.poseidon.service.oa.IOaUrlInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.muggle.poseidon.base.ResultBean.successData;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/poseidon/oa-url-info")
public class OaUrlInfoController  {

    @Autowired
    IOaUrlInfoService urlInfoService;

// 全字段查询

    @PostMapping("/query_url")
    public ResultBean<Page<OaUrlInfo>> getUrlInfo(@RequestBody OaUrlInfoQuery oaUrlInfoQuery){
        return ResultBean.successData(urlInfoService.getUrlInfo(oaUrlInfoQuery));
    }

    @PostMapping("/test")
    public ResultBean<Page<OaUrlInfo>> test(){
        return successData(urlInfoService.test());
    }

    public static void main(String[] args) {
        OaUrlInfoQuery oaUrlInfoQuery = new OaUrlInfoQuery();
        oaUrlInfoQuery.setUrl("/query_url");
        Map<String, BaseNormalQuery.Operator> op=new HashMap<>();
        op.put("url", BaseNormalQuery.Operator.equals);
        oaUrlInfoQuery.setOperatorMap(op);
        String s= JSON.toJSONString(oaUrlInfoQuery);
        System.out.println(s);
    }
}
