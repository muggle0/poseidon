package com.muggle.poseidon.oa.service.helper;

import com.muggle.poseidon.entity.oa.OaUserInfo;
import com.muggle.poseidon.entity.oa.vo.OaUserVO;
import com.muggle.poseidon.oa.security.OaUserInfoTool;
import com.muggle.poseidon.util.RequestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/6/2
 **/
public class UserHelper {

    public static OaUserInfo newUserInfo(OaUserVO userVO) {
        Date now = new Date();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String ip = RequestUtils.getIP(attributes.getRequest());
        OaUserInfo oaUserInfo = new OaUserInfo();
        oaUserInfo.setEamil(userVO.getEmail());
        oaUserInfo.setImgPath(userVO.getImgUrl());
        oaUserInfo.setAccountNonLocked(true);
        oaUserInfo.setLastLoginIp(ip);
        oaUserInfo.setLastLoginTime(now);
        oaUserInfo.setGmtModified(now);
        oaUserInfo.setPassword(OaUserInfoTool.encode(userVO.getPassword()));
        oaUserInfo.setGender(userVO.getGender());
        oaUserInfo.setUsername(userVO.getUsername());
        oaUserInfo.setAccountNonExpired(true);
        oaUserInfo.setCredentialsNonExpired(true);
        oaUserInfo.setEnabled(true);
        return oaUserInfo;
    }

}
