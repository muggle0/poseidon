package com.muggle.poseidon.core.config;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import com.muggle.poseidon.service.PoseidonGrantedAuthorityService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

public class PoseidonExpressionVoter extends WebExpressionVoter {
    private static final AntPathMatcher antPathMatcher = new AntPathMatcher();


    //   authentication 为securityContextHolder里面的用户信息  attributes为 attributes（已认证） 或者    ----securityconfig中配置的内容
    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        String requestUrl = fi.getRequestUrl();
        if (antPathMatcher.match("/public/**", requestUrl) || antPathMatcher.match("/sign_up", requestUrl) || antPathMatcher.match("/sign_page", requestUrl)) {
            return ACCESS_GRANTED;
        }
        String method = fi.getHttpRequest().getMethod();
        assert authentication != null;
        assert fi != null;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        assert authorities != null;
        int size = authorities.size();
        Object[] objects = new Object[size];
        authorities.toArray(objects);
        if (size > 0) {
            if (!(objects[0] instanceof PoseidonGrantedAuthority)) {
                return ACCESS_ABSTAIN;
            }
        } else {
            return ACCESS_DENIED;
        }
        for (int i = 0; i < size; i++) {
            PoseidonGrantedAuthority value = (PoseidonGrantedAuthority) objects[i];
            boolean math = "ALL".equalsIgnoreCase(value.getMethod()) ? true : method.equals(value.getMethod());
            boolean bool = value.getEnable() != null && value.getEnable() && antPathMatcher.match(value.getUrl(), requestUrl) && math;
            if (bool) {
                return ACCESS_GRANTED;
            }
        }
        return ACCESS_DENIED;
    }
}
