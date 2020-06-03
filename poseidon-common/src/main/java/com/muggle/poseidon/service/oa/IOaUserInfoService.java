package com.muggle.poseidon.service.oa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author muggle
 * @since 2020-05-28
 */
public interface IOaUserInfoService extends IService<OaUserInfo> {

    /**
     * 用户注册
     * @param userVO
     * @return
     */
    OaUserInfo regester(OaUserVO userVO);

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    OaUserInfo getUserInfo(@NotNull(message = "请输入用户名") String username);
}
