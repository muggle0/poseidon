package com.muggle.poseidon.oa.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.query.OaUrlInfoQuery;
import com.muggle.poseidon.oa.mapper.OaUrlInfoMapper;
import com.muggle.poseidon.service.oa.IOaUrlInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
@Service
public class OaUrlInfoServiceImpl extends ServiceImpl<OaUrlInfoMapper, OaUrlInfo> implements IOaUrlInfoService {

    @Override
    public Page<OaUrlInfo> getUrlInfo(OaUrlInfoQuery oaUrlInfoQuery) {
        return baseMapper.getUrlInfo( oaUrlInfoQuery);
    }

    @Override
    public Page<OaUrlInfo> test() {
        PageHelper.startPage(1,10);
        Page<OaUrlInfo> test = baseMapper.test();
        return test;
    }
}
