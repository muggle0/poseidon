package com.muggle.poseidon.core.config;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.Collection;

public class PoseidonExpressionVoter extends WebExpressionVoter {

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        assert authentication != null;
        assert fi != null;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        assert authorities != null;
        int size = attributes.size();
        Object[] objects = new Object[size];
        attributes.toArray(objects);
        if (size>0){
            if (!(objects[0] instanceof PoseidonGrantedAuthority)){
                return ACCESS_ABSTAIN;
            }
        }else {
            return ACCESS_DENIED ;
        }
        for (int i=0;i<size;i++){

        }
        String requestUrl = fi.getRequestUrl();
        String method = fi.getHttpRequest().getMethod();
        for(int i=0;i<size;i++){
            PoseidonGrantedAuthority value=(PoseidonGrantedAuthority)objects[i];
            boolean bool=value.getEnable()!=null&&value.getEnable()&& requestUrl.equals(value.getUrl())&& method.equals(value.getUrl());
           if (bool){
               return ACCESS_GRANTED;
           }

        }

        return ACCESS_DENIED;
    }
}
