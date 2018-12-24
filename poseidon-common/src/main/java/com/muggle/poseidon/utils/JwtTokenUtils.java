package com.muggle.poseidon.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @program: poseidon
 * @description: Token工具类
 * @author: muggle
 * @create: 2018-12-22 15:05
 **/

public class JwtTokenUtils {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "poseidon-system";
    private static final String ISS = "muggle";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;

    // 创建token
    public static String createToken(String username, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)// 签名算法以及密匙
                .setIssuer(ISS)// 签发者
                .setSubject(username)// 主题
                .setIssuedAt(new Date())// 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))// 过期时间
                .compact();
    }

    // 从token中获取用户名
    public static String getUsername(String token){
        String subject = getTokenBody(token).getSubject();

        return subject;
    }

    // 是否已过期
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
