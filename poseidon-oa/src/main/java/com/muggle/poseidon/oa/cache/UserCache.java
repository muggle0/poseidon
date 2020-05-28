package com.muggle.poseidon.oa.cache;

import com.muggle.poseidon.entity.oa.OaUserInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/28
 **/
public class UserCache {
    private static Map<String, OaUserInfo> userInfoMap=new ConcurrentHashMap<>();

    public static OaUserInfo getUserInfo(String key){
        return userInfoMap.get(key);
    }

    public static void setUserInfo(OaUserInfo oaUserInfo){
        String username = oaUserInfo.getUsername();
        userInfoMap.put(username,oaUserInfo);
    }

}
