package com.muggle.poseidon.manager;

import com.muggle.poseidon.entity.PoseidonGrantedAuthority;
import com.muggle.poseidon.entity.PoseidonUserDetail;
import com.muggle.poseidon.entity.Role;
import com.muggle.poseidon.entity.UserInfoDTO;
import com.muggle.poseidon.manage.UserInfoManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class UserInfoManagerImpl implements UserInfoManager {
    /*public static PoseidonUserDetail getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null && context.getAuthentication() != null) {
            Object details = context.getAuthentication().getPrincipal();
            if (details instanceof PoseidonUserDetail) {
                PoseidonUserDetail authentication = (PoseidonUserDetail) details;
                return authentication;
            }
        }
        return null;
    }

    public static void setUser(UsernamePasswordAuthenticationToken token) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null && context.getAuthentication() != null) {
            context.setAuthentication(token);
        }
    }

    public static void clearUser() {
        SecurityContextHolder.clearContext();
    }

    public static List<String> getRoleCodes() {
        Iterator<Role> iterator = getUser().getRoles().iterator();
        List<String> roleCodes = new ArrayList<>();
        while (iterator.hasNext()) {
            roleCodes.add(iterator.next().getRoleCode());
        }
        return roleCodes;
    }

    public static List<String> getAuthoritys() {
        PoseidonUserDetail user = getUser();
        Set<PoseidonGrantedAuthority> authorities = user.getAuthorities();
        Iterator<PoseidonGrantedAuthority> iterator = authorities.iterator();
        List<String> author = new ArrayList<>();
        while (iterator.hasNext()) {
            author.add(iterator.next().getAuthority());
        }
        return author;
    }

    public static String getUserId() {
        PoseidonUserDetail user = getUser();
        if (user==null){
            return "-1";
        }
        return user.getId();
    }*/

    @Override
    public UserInfoDTO getUserInfo() {
        UserInfoDTO.UserInfoDTOBuilder builder = UserInfoDTO.builder();
        SecurityContext context = SecurityContextHolder.getContext();
        if  (context != null && context.getAuthentication() != null) {
            Object details = context.getAuthentication().getPrincipal();
            if (details instanceof PoseidonUserDetail) {
                PoseidonUserDetail authentication = (PoseidonUserDetail) details;
                    builder.birthday(authentication.getBirthday()).id(authentication.getId()).imgUrl(authentication.getImgUrl());
                Set<Role> roles = authentication.getRoles();
                List<@NotNull String> collect = roles.stream().map(role -> {
                    return role.getRoleCode();
                }).collect(toList());
                UserInfoDTO build = builder.nickname(authentication.getNickname()).roleCodes(collect).build();
                return build;
            }
        }
        UserInfoDTO anmouse = UserInfoDTO.builder().id("-1").username("anmouse").build();
        return anmouse;
    }
}
