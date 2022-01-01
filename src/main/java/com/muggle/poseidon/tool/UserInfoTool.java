package com.muggle.poseidon.tool;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.muggle.poseidon.entity.pojo.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

        return null;
    }

    public static SysUser parserToken(String token) {
        return null;
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
