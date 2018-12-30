package com.muggle.poseidon.core.config;

import com.muggle.poseidon.model.PoseidonGrantedAuthority;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class PoseidonExpressionVoter extends WebExpressionVoter {

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        assert authentication != null;
        assert fi != null;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        assert authorities != null;
        if (authorities.size()==0){
            return  ACCESS_ABSTAIN;
        }
        try {
            Iterator<PoseidonGrantedAuthority> iterator = ((HashSet<PoseidonGrantedAuthority>) authorities).iterator();
            String requestUrl = fi.getRequestUrl();
            while (iterator.hasNext()){
                if (iterator.next().getAuthority().equals(requestUrl)){
                    return ACCESS_GRANTED;
                }
            }
            return ACCESS_DENIED;
        }catch (Exception e){
            return ACCESS_ABSTAIN;
        }
//       throw new AccessDeniedException("无权限");
       /* String requestUrl = fi.getRequestUrl();

       return ACCESS_GRANTED;*/
    }
}
