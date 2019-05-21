package com.muggle.poseidon.entity;

import org.springframework.security.core.GrantedAuthority;

public class OtherGrantedAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return null;
    }
}
