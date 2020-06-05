package com.muggle.poseidon.oa.security;

import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import com.muggle.poseidon.base.exception.SimplePoseidonException;
import com.muggle.poseidon.util.JwtTokenUtils;
import com.muggle.poseidon.util.UserInfoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/5/28
 **/

public class OaUserInfoTool extends UserInfoUtils {
    private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();


    public  static UserDetails covertToken(String token,String credential) throws BasePoseidonCheckException {
        try {
            String username = JwtTokenUtils.getBody(token, credential, "username").toString();
            Object body = JwtTokenUtils.getBody(token, credential, "roles");
            if (username==null||body==null){
                return null;
            }
            List<String> roles =(List<String>) (body);
            List<SimpleGrantedAuthority> authorities=new ArrayList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            User user = new User(username, "system", authorities);
            return user;
        }catch (SimplePoseidonException e){
            throw new SimplePoseidonCheckException(e.getMessage());
        }
        catch (Exception e){
          throw new SimplePoseidonCheckException("无效的凭证");
        }
    }

    public static String encode(String password){
        return encoder.encode(password);
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword,encodedPassword);
    }
}
