package com.muggle.poseidon.tool;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.muggle.poseidon.entity.pojo.OaUserInfo;
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

    public static String creakeToken(OaUserInfo userInfo){
        List<String> collect = userInfo.getAuthorities().stream()
                .map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList());
        Map<String, Object> claims=new HashMap<>();
        claims.put("id",userInfo.getId());
        claims.put("username",userInfo.getUsername());
        claims.put("role",collect);
        String compact = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600000L))
                .setClaims(claims).compact();
        return compact;
    }

    public static OaUserInfo parserToken(String token) {
        Claims body = Jwts.parser().setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody();
        OaUserInfo userInfo = new OaUserInfo();
        userInfo.setId(((Long) body.get("id")));
        userInfo.setUsername(body.get("username").toString());
        List<String> strings = (List<String>) body.get("role");
        List<SimpleGrantedAuthority> collect = strings.stream().map(role ->
                new SimpleGrantedAuthority(role)
        ).collect(Collectors.toList());
        userInfo.setAuthorities(collect);
        userInfo.setEnabled(true);
        userInfo.setAccountNonExpired(true);
        userInfo.setAccountNonLocked(true);
        return userInfo;
    }

    public static OaUserInfo getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null){
            return null;
        }
        Object details = authentication.getDetails();
        if (details==null||!(details instanceof OaUserInfo)){
            return null;
        }
        return (OaUserInfo) details;
    }
}
