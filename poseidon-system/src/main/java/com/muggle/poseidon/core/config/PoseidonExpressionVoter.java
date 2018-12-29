package com.muggle.poseidon.core.config;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PoseidonExpressionVoter extends WebExpressionVoter {
    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        assert authentication != null;
        assert fi != null;
        assert attributes != null;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        assert authorities != null;
        if (attributes.size()==0){
            return ACCESS_ABSTAIN;
        }
        if (authorities.size()==0){
            return  ACCESS_DENIED;
        }
        authorities.
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        Set<String> role=new HashSet<>();
        while (iterator.hasNext()){
            GrantedAuthority next = iterator.next();
        }
        attributes.forEach(role->{
            String attribute = role.getAttribute();
            iterator
        });
    }
}
