package com.muggle.poseidon.service.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muggle.poseidon.entity.OaUserInfo;
import com.muggle.poseidon.mapper.OaUrlInfoMapper;
import com.muggle.poseidon.mapper.OaUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/11
 **/
@Service
public class UserInfoManager {
    @Autowired
    private OaUserInfoMapper oaUserInfoMapper;


    public OaUserInfoMapper getOaUserInfoMapper() {
        return oaUserInfoMapper;
    }



    public UserDetails loadUserByUsername(String username) {
        QueryWrapper<OaUserInfo> oaUserInfoQueryWrapper = new QueryWrapper<>();
        oaUserInfoQueryWrapper.lambda().eq(OaUserInfo::getNickname,username);
        OaUserInfo oaUserInfo = oaUserInfoMapper.selectOne(oaUserInfoQueryWrapper);
        return oaUserInfo;
    }
}
