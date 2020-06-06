package com.muggle.poseidon.oa.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.base.query.BaseNormalQuery;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.query.OaUrlInfoQuery;
import com.muggle.poseidon.service.oa.IOaUrlInfoService;
import io.swagger.annotations.*;
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
@Api(value="URL信息接口")
public class OaUrlInfoController  {

    @Autowired
    IOaUrlInfoService urlInfoService;

// 全字段查询

    @PostMapping("/query_url")
    @ApiOperation(value = "查询url  该查询接口后端使用的是查询组件 （查询组件使用方式请看文档）",response = OaUrlInfo.class)
    public ResultBean<Page<OaUrlInfo>> getUrlInfo(@ApiParam(name="url对象",value="传入json格式",required=true) @RequestBody OaUrlInfoQuery oaUrlInfoQuery){
        return ResultBean.successData(urlInfoService.getUrlInfo(oaUrlInfoQuery));
    }

}
