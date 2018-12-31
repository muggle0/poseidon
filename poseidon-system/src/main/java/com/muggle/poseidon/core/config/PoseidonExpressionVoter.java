package com.muggle.poseidon.core.config;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

public class PoseidonExpressionVoter extends WebExpressionVoter {
    private AntPathMatcher antPathMatcher;

    public  PoseidonExpressionVoter(AntPathMatcher antPathMatcher){
        this.antPathMatcher=antPathMatcher;
    }

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
            boolean math="ALL".equalsIgnoreCase(value.getMethod())? true: method.equals(value.getMethod());
            boolean bool=value.getEnable()!=null&&value.getEnable()&& antPathMatcher.match(value.getUrl(),requestUrl)&& math;
           if (bool){
               return ACCESS_GRANTED;
           }
        }

        return ACCESS_DENIED;
    }
}
