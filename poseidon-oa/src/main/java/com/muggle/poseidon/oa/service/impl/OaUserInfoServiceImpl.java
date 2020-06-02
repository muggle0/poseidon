package com.muggle.poseidon.oa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;
import com.muggle.poseidon.oa.mapper.OaUserInfoMapper;
import com.muggle.poseidon.service.oa.IOaUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-05-28
 */
@Service
public class OaUserInfoServiceImpl extends ServiceImpl<OaUserInfoMapper, OaUserInfo> implements IOaUserInfoService {

    @Override
    public OaUserInfo regester(OaUserVO userVO) {

        return null;
    }

    @Override
    public OaUserInfo getUserInfo(String username) {
        return null;
    }
}
