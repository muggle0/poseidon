package com.sofia.poseidon.tool;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.muggle.poseidon.util.JwtTokenUtils;
import com.sofia.poseidon.entity.pojo.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/13
 **/
public class UserInfoTool {
    private static String signingKey;
    static {
        signingKey= UUID.randomUUID().toString();
    }

    public static String creakeToken(SysUser userInfo){
        Map<String, Object> body=new HashMap<>();
        body.put("id",userInfo.getId());
        final String token = JwtTokenUtils.createToken(body, signingKey);
        return token;
    }

    public static String parserToken(String token) {
        final Object id = JwtTokenUtils.getBody(token, signingKey, "id");
        return id.toString();
    }

    public static SysUser getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null){
            return null;
        }
        Object details = authentication.getDetails();
        if (details==null||!(details instanceof SysUser)){
            return null;
        }
        return (SysUser) details;
    }
}
