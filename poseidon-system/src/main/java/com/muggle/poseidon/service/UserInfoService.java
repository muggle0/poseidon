package com.muggle.poseidon.service;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserInfoService {
    public static PoseidonUserDetail getUser() {
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
    }
}
