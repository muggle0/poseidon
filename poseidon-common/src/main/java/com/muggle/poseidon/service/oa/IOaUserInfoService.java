package com.muggle.poseidon.service.oa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author muggle
 * @since 2020-05-28
 */
public interface IOaUserInfoService extends IService<OaUserInfo> {

    OaUserInfo regester(OaUserVO userVO);

    OaUserInfo getUserInfo(String username);
}
