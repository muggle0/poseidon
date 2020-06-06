package com.muggle.poseidon.service.oa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.muggle.poseidon.entity.oa.OaUrlInfo;
import com.muggle.poseidon.entity.oa.query.OaUrlInfoQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author muggle
 * @since 2020-05-29
 */
public interface IOaUrlInfoService extends IService<OaUrlInfo> {

    Page<OaUrlInfo> getUrlInfo(OaUrlInfoQuery oaUrlInfoQuery);

    Page<OaUrlInfo> test();

}
