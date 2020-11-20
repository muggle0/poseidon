package com.muggle.poseidon.service;

import com.muggle.poseidon.entity.form.OaUserForm;
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

    /**
     * 保存用户信息
     * @param userForm
     * @return
     */
    OaUserVO save(OaUserForm userForm);

    /**
     * 获取用户信息
     * @return
     */
    OaUserVO getUserInfo();

    /**
     * 更新用户信息
     * @param userForm
     * @return
     */
    OaUserVO update(OaUserForm userForm);
}
