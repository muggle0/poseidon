package com.muggle.poseidon.config;

import com.muggle.poseidon.filter.PoseidonTokenFilter;
import com.muggle.poseidon.handler.PoseidonAuthenticationFailureHandler;
import com.muggle.poseidon.handler.PoseidonAuthenticationSuccessHandler;
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
        web.ignoring().antMatchers("/*.html", "/**/*.jsp", "/**/*.css", "/**/*.js",
                "/**/*.bmp", "/**/*.gif", "/**/*.png", "/**/*.jpg", "/**/*.ico");
//        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/test/**").permitAll()
                // user权限可以访问的请求
                .antMatchers("/security/user").hasRole("user")
                // admin权限可以访问的请求
                .antMatchers("/security/admin").hasRole("admin")
                //SpEL表达式:需要拥有user权限，且进行了完全认证
                .antMatchers("/user/account").access("hasRole('user') and isFullyAuthenticated()")
                // 其他地址的访问均需验证权限（需要登录）
                .anyRequest().authenticated().and()
                // 添加验证码验证
                // 指定登录页面的请求路径
                .formLogin().loginPage("/login_page")
                // 登陆处理路径
                .loginProcessingUrl("/auth_login").permitAll().and()
                //退出请求的默认路径为logout，下面改为signout， 成功退出登录后的url可以用logoutSuccessUrl设置
                .logout().logoutUrl("/signout").logoutSuccessUrl("/login_page").permitAll().and()
                // 开启rememberMe，设置一个私钥专供testall项目使用，注意与下面TokenBasedRememberMeServices的key保持一致
                .rememberMe().key("testallKey").and()
                // 关闭csrf
                .csrf().disable();
        http.addFilterAt(this.customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//        super.configure(http);
    }
    PoseidonTokenFilter customAuthenticationFilter() throws Exception {
        PoseidonTokenFilter filter = new PoseidonTokenFilter();
        filter.setAuthenticationSuccessHandler(new PoseidonAuthenticationSuccessHandler());
        filter.setAuthenticationFailureHandler(new PoseidonAuthenticationFailureHandler());
        filter.setAuthenticationManager(authenticationManagerBean());//加入这一行才会正常执行Filter中的 Handler
        return filter;
    }

}
