package com.muggle.poseidon.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muggle.poseidon.base.OAException;
import com.muggle.poseidon.entity.oa.OaRole;
import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;
import com.muggle.poseidon.oa.mapper.OaRoleMapper;
import com.muggle.poseidon.oa.mapper.OaUserInfoMapper;
import com.muggle.poseidon.service.oa.IOaUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    OaRoleMapper oaRoleMapper;
    @Override
    public OaUserInfo regester(OaUserVO userVO) {
        return null;
    }

    @Override
    public OaUserInfo getUserInfo(String username) {
        QueryWrapper<OaUserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        OaUserInfo oaUserInfo = baseMapper.selectOne(queryWrapper);
        if (oaUserInfo==null){
            throw new OAException("找不到该用户");
        }
        List<OaRole> roles = oaRoleMapper.selectByUsername(username);
        oaUserInfo.setAuthorities(roles);
        return oaUserInfo;
    }
}
