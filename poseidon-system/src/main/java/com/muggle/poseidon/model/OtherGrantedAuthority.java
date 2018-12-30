package com.muggle.poseidon.model;

import org.springframework.security.core.GrantedAuthority;

public class OtherGrantedAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return null;
    }
}
