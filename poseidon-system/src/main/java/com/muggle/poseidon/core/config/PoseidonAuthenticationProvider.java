package com.muggle.poseidon.core.config;

import com.muggle.poseidon.core.exception.BadTokenException;
import com.muggle.poseidon.model.MessagePrincipal;
import com.muggle.poseidon.model.PoseidonSign;
import com.muggle.poseidon.service.PoseidonSignService;
import com.muggle.poseidon.service.PoseidonUserdetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @program: workspace
 * @description: ProviderManager把工作委托给AuthenticationProvider集合。ProviderManager将所有AuthenticationProvider进行循环，直到运行返回一个完整的Authentication，不符合条件或者不能认证当前Authentication，返回AuthenticationException异常或者null。
 * @author: muggle
 * @create: 2018-09-18 19:27
 **/
/*AuthenticationProvider: ProviderManager的工作被委托者*/
@Slf4j
public class PoseidonAuthenticationProvider implements AuthenticationProvider {
   private UserDetailsService userDetailsService;
   private PoseidonSignService poseidonSignService;
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
        if (!(principal.getCode().equals(2))){
            return null;
        }
        final PoseidonSign poseidonSign = poseidonSignService.loadByPrincipal(principal.getPrincipal());
        UserDetails one = ((PoseidonUserdetailsService) userDetailsService).findOne(poseidonSign.getUserId());

        log.info("验证用户");
       throw new BadTokenException("测试》》》》》","ssssssssssssssssssssss");
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(aClass));
    }
}
