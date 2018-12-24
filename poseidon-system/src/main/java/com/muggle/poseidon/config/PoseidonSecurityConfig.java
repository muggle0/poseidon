package com.muggle.poseidon.config;

import com.muggle.poseidon.filter.PoseidonTokenFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @program: poseidon
 * @description: 安全配置
 * @author: muggle
 * @create: 2018-12-22 11:46
 **/
@Configuration
@EnableWebSecurity
//开启注解方法拦截
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PoseidonSecurityConfig extends WebSecurityConfigurerAdapter {
    /*Spring安全提供了一些配置帮助类，以便快速的在应用中创建通用的身份验证功能。
        最常用的帮助类是 AuthenticationManagerBuilder
        采用自定义的AuthenticationManager 所以不重写该方法
    */
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        super.configure(auth);
    }
*/
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(this.customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }
    PoseidonTokenFilter customAuthenticationFilter() throws Exception {
        PoseidonTokenFilter filter = new PoseidonTokenFilter();
//        filter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
//        filter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        filter.setAuthenticationManager(authenticationManagerBean());//加入这一行才会正常执行Filter中的 Handler
        return filter;
    }
}
