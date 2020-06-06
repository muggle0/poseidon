package com.muggle.poseidon.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.query.OaUrlInfoQuery;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
public interface OaUrlInfoMapper extends BaseMapper<OaUrlInfo> {

    Page<OaUrlInfo> getUrlInfo(OaUrlInfoQuery oaUrlInfoQuery);

    Page<OaUrlInfo> test();

}
