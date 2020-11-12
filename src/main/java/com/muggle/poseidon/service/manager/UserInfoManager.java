package com.muggle.poseidon.service.manager;

import com.muggle.poseidon.entity.OaUserInfo;
import com.muggle.poseidon.mapper.OaUrlInfoMapper;
import com.muggle.poseidon.mapper.OaUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @Autowired
//    private


    public OaUserInfoMapper getOaUserInfoMapper() {
        return oaUserInfoMapper;
    }

    public OaUserInfo login(String username, String password) {
        return null;
    }
}
