package com.muggle.poseidon.core.config;

import com.muggle.poseidon.core.exception.BadTokenException;
import com.muggle.poseidon.entity.dto.MessagePrincipal;
import com.muggle.poseidon.entity.PoseidonSign;
import com.muggle.poseidon.entity.PoseidonUserDetail;
import com.muggle.poseidon.service.impl.PoseidonUserdetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.muggle.poseidon.core.properties.TokenProperties;

import java.util.Optional;

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
   public PoseidonAuthenticationProvider(BCryptPasswordEncoder bCryptPasswordEncoder,UserDetailsService userDetailsService){
       this.bCryptPasswordEncoder=bCryptPasswordEncoder;
       this.userDetailsService=userDetailsService;
   }
   
   
   /** 
   * @Description: 验证器的验证方法   
   * @Param:  authentication 用户的登陆信息
   * @return:  
   */ 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//      抛出异常无法终止验证
       if (!(authentication.getPrincipal() instanceof MessagePrincipal)){
           return null;
       }
       MessagePrincipal principal= (MessagePrincipal) authentication.getPrincipal();
        if (!(principal.getCode().equals(TokenProperties.MESSAGE_CODE))){
            return null;
        }
        PoseidonUserdetailsServiceImpl poseidonUserdetailsService = (PoseidonUserdetailsServiceImpl) userDetailsService;
        final PoseidonSign poseidonSign = poseidonUserdetailsService.loadByPrincipal(principal.getUsername());
        if ( poseidonSign.getEnable()==0){
            throw new BadTokenException(TokenProperties.ABNORMAL_ACCOUNT,TokenProperties.BAD_TOKEN_CODE);
        }
//        数据库有数据且无密码或者密码匹配（因为关联验证类型可能不需要密码校验）
        boolean isCredentials=poseidonSign!=null&&(poseidonSign.getCredentials()==null||poseidonSign.getCredentials().equals(authentication.getCredentials()));
        if (!isCredentials){
            return null;
        }
        if ( poseidonSign.getEnable()==0){
            throw new BadTokenException(TokenProperties.ABNORMAL_ACCOUNT,TokenProperties.BAD_TOKEN_CODE);
        }
        log.info("验证用户登录："+principal);
        Optional<PoseidonUserDetail> optional = poseidonUserdetailsService.findOne(poseidonSign.getUserId());
        if (!optional.isPresent()){
            throw new BadTokenException(TokenProperties.ABNORMAL_ACCOUNT,TokenProperties.BAD_TOKEN_CODE);
        }
        PoseidonUserDetail one = optional.get();
        boolean bool=one.isAccountNonExpired()&&one.isEnabled()&&one.isAccountNonLocked();
        if(!bool){
            throw new BadTokenException(TokenProperties.ABNORMAL_ACCOUNT,TokenProperties.BAD_TOKEN_CODE);
        }
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(one,one.getPassword(),one.getAuthorities());
        token.setDetails("id:"+one.getId());
        return token;
    }
    
    /** 
    * @Description: 判断验证器是否执行
    * @Param: sss
    * @return:
    */ 
    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(aClass));
    }

}
