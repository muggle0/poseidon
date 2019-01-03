package com.muggle.poseidon.service;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.model.PoseidonUserDetail;
import com.muggle.poseidon.model.Role;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserInfoService {
    public static PoseidonUserDetail getUser(){
        return (PoseidonUserDetail) SecurityContextHolder.getContext().getAuthentication();
    }
    public static void clearUser(){
        SecurityContextHolder.clearContext();
    }
    public static List<String> getRoleCodes(){
        Iterator<Role> iterator = getUser().getRoles().iterator();
        List<String> roleCodes=new ArrayList<>();
        while (iterator.hasNext()){
            roleCodes.add(iterator.next().getRoleCode());
        }
        return roleCodes;
    }
    public static List<String> getAuthoritys(){
        PoseidonUserDetail user = getUser();
        Set<PoseidonGrantedAuthority> authorities = user.getAuthorities();
        Iterator<PoseidonGrantedAuthority> iterator = authorities.iterator();
        List<String> author=new ArrayList<>();
        while (iterator.hasNext()){
            author.add(iterator.next().getAuthority());
        }
        return author;
    }
}
