//package com.muggle.poseidon.oauth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * @program: poseidon-cloud-all
// * @description:
// * @author: muggle
// * @create: 2019-05-25
// **/
//
//
//
//@EnableResourceServer
////@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class ResServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Autowired
//    TokenStore tokenStore;
//
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore);
//        resources.tokenServices(defaultTokenServices);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/a").permitAll() // 放开权限的url
//                .anyRequest().authenticated();
//    }
///*
//    *//**
//     * 判断来源请求是否包含oauth2授权信息<br>
//     * url参数中含有access_token,或者header里有Authorization
//     *//*
//    private static class OAuth2RequestedMatcher implements RequestMatcher {
//        @Override
//        public boolean matches(HttpServletRequest request) {
//            // 请求参数中包含access_token参数
//            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
//                return true;
//            }
//
//            // 头部的Authorization值以Bearer开头
//            String auth = request.getHeader("Authorization");
//            if (auth != null) {
//                return auth.startsWith(OAuth2AccessToken.BEARER_TYPE);
//            }
//
//            return false;
//        }
//    }
//
//    public TokenStore tokenStore() {
//
//        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
//        // 解决同一username每次登陆access_token都相同的问题
//        redisTokenStore.setAuthenticationKeyGenerator(new RandomAuthenticationKeyGenerator());
//
//        return redisTokenStore;
//    }
//
//    public static class RandomAuthenticationKeyGenerator implements AuthenticationKeyGenerator {
//        @Override
//        public String extractKey(OAuth2Authentication oAuth2Authentication) {
//            return UUID.randomUUID().toString();
//        }
//    }*/
//}
//
