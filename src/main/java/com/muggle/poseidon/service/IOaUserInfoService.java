package com.muggle.poseidon.service;

import com.muggle.poseidon.entity.pojo.OaUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.muggle.poseidon.entity.vo.OaUserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author muggle
 * @since 2020-11-11
 */
public interface IOaUserInfoService extends IService<OaUserInfo> {

    OaUserVO save(OaUserVO oaUserVO);
}
