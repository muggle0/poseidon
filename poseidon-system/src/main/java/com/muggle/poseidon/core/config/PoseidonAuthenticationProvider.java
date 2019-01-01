package com.muggle.poseidon.core.config;

import com.muggle.poseidon.core.exception.BadTokenException;
import com.muggle.poseidon.model.MessagePrincipal;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.service.impl.PoseidonUserdetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.muggle.poseidon.core.properties.TokenProperties;

/**
 * @program: poseidon
 * @description: ProviderManager把工作委托给AuthenticationProvider集合。ProviderManager将所有AuthenticationProvider进行循环，直到运行返回一个完整的Authentication，不符合条件或者不能认证当前Authentication，返回AuthenticationException异常或者null。
 * @author: muggle
 * @create: 2018-09-18 19:27
 **/
/*AuthenticationProvider: ProviderManager的工作被委托者*/
@Slf4j
public class PoseidonAuthenticationProvider implements AuthenticationProvider {
   private UserDetailsService userDetailsService;
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   public PoseidonAuthenticationProvider(BCryptPasswordEncoder bCryptPasswordEncoder,UserDetailsService userDetailsServices){
       this.bCryptPasswordEncoder=bCryptPasswordEncoder;
       this.userDetailsService=userDetailsService;
   }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

       if (!(authentication.getPrincipal() instanceof MessagePrincipal)){
           return null;
       }
       MessagePrincipal principal= (MessagePrincipal) authentication.getPrincipal();
        if (!(principal.getCode().equals(TokenProperties.MESSAGE_CODE))){
            return null;
        }
        PoseidonUserdetailsServiceImpl poseidonUserdetailsService = (PoseidonUserdetailsServiceImpl) userDetailsService;
        final PoseidonSign poseidonSign = poseidonUserdetailsService.loadByPrincipal(principal.getPrincipal());
        final String verification = poseidonUserdetailsService.getVerification("message-" + principal.getPrincipal());
        if (poseidonSign==null||!poseidonSign.getCredentials().equals(verification)){
            return null;
        }
        log.info("验证用户登录："+principal);
        final UserDetails one = poseidonUserdetailsService.findOne(poseidonSign.getUserId());
        boolean bool=one.isAccountNonExpired()&&one.isEnabled()&&one.isAccountNonLocked();
        if(!bool){
            throw new BadTokenException(TokenProperties.ABNORMAL_ACCOUNT,TokenProperties.BAD_TOKEN_CODE);
        }
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(one.getUsername(),one.getPassword(),one.getAuthorities());
        token.setDetails(one);
        return token;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(aClass));
    }
}
