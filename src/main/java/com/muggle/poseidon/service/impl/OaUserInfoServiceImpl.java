package com.muggle.poseidon.service.impl;

import com.muggle.poseidon.entity.pojo.OaUserInfo;
import com.muggle.poseidon.entity.vo.OaUserVO;
import com.muggle.poseidon.mapper.OaUserInfoMapper;
import com.muggle.poseidon.mapstruct.UserInfoMapstruct;
import com.muggle.poseidon.service.IOaUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.tool.UserInfoTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author muggle
 * @since 2020-11-11
 */
@Service
public class OaUserInfoServiceImpl extends ServiceImpl<OaUserInfoMapper, OaUserInfo> implements IOaUserInfoService {

    @Autowired
    OaUserInfoMapper userInfoMapper;
    @Autowired
    UserInfoMapstruct userInfoMapstruct;
    @Override
    public OaUserVO save(OaUserVO oaUserVO) {
        return null;
    }

    @Override
    public OaUserVO getUserInfo() {
        OaUserInfo userInfo = UserInfoTool.getUserInfo();
        OaUserInfo dbUserInfo = userInfoMapper.selectById(userInfo.getId());
        dbUserInfo.setAuthorities(userInfo.getAuthorities());
        OaUserVO oaUserVO = userInfoMapstruct.getUserVO(dbUserInfo);
        return oaUserVO;
    }
}
