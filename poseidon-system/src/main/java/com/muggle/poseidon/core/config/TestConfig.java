package com.muggle.poseidon.core.config;

import com.muggle.poseidon.core.filter.PoseidonTokenFilter;
import com.muggle.poseidon.core.handler.PoseidonAuthenticationFailureHandler;
import com.muggle.poseidon.core.handler.PoseidonAuthenticationSuccessHandler;
import com.muggle.poseidon.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-28 12:50
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class TestConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    RedisService redisService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/resources/**/*.html", "/resources/**/*.js",
                "/resources/**/*.css", "/resources/**/*.txt",
                "/resources/**/*.png", "/**/*.bmp", "/**/*.gif", "/**/*.png", "/**/*.jpg", "/**/*.ico");
//        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/sign_up", "/public/**").permitAll()
                .antMatchers("/test/role").hasRole("test")
                .antMatchers("/**").authenticated().and()
                .formLogin().usernameParameter("username").passwordParameter("password").loginPage("/login_page").loginProcessingUrl("/sign_in")
                .permitAll().and().csrf().disable();
        http.addFilterAt(poseidonTokenFilter(),UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint( macLoginUrlAuthenticationEntryPoint());
//        http.addFilter()
//        super.configure(http);
    }
    @Override
    protected AuthenticationManager authenticationManager()  {
        ProviderManager authenticationManager = new ProviderManager(Arrays.asList(poseidonAuthenticationProvider(),daoAuthenticationProvider()));
        //不擦除认证密码，擦除会导致TokenBasedRememberMeServices因为找不到Credentials再调用UserDetailsService而抛出UsernameNotFoundException
        authenticationManager.setEraseCredentialsAfterAuthentication(false);
        return authenticationManager;
    }

    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
    PoseidonAuthenticationProvider poseidonAuthenticationProvider(){
        PoseidonAuthenticationProvider poseidonAuthenticationProvider=new PoseidonAuthenticationProvider(bCryptPasswordEncoder,userDetailsService);
        return poseidonAuthenticationProvider;
    }
    PoseidonTokenFilter poseidonTokenFilter(){
        final PoseidonTokenFilter poseidonTokenFilter = new PoseidonTokenFilter(redisService);
        poseidonTokenFilter.setAuthenticationSuccessHandler(new PoseidonAuthenticationSuccessHandler());
        poseidonTokenFilter.setAuthenticationFailureHandler(new PoseidonAuthenticationFailureHandler());
        poseidonTokenFilter.setAuthenticationManager(authenticationManager());
        return poseidonTokenFilter;
    }

    public AuthenticationEntryPoint macLoginUrlAuthenticationEntryPoint() {
        return new PoseidonLoginUrlAuthenticationEntryPoint("/login_page");
    }
}
