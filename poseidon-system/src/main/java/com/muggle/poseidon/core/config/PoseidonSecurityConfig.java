
package com.muggle.poseidon.core.config;

import com.muggle.poseidon.core.filter.PoseidonTokenFilter;
import com.muggle.poseidon.core.handler.PoseidonAccessDeniedHandler;
import com.muggle.poseidon.core.handler.PoseidonAuthenticationFailureHandler;
import com.muggle.poseidon.core.handler.PoseidonAuthenticationSuccessHandler;
import com.muggle.poseidon.core.properties.SecurityProperties;
import com.muggle.poseidon.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
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
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-28 12:50
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class PoseidonSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    RedisService redisService;
    @Autowired
    SecurityProperties properties;


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
                .anyRequest().authenticated().accessDecisionManager(accessDecisionManager())
                .and().formLogin().usernameParameter(properties.getUsername()).passwordParameter(properties.getPassword()).loginPage(properties.getPage()).loginProcessingUrl(properties.getProcesses())
                .permitAll().and().csrf().disable();
        http.addFilterAt(poseidonTokenFilter(),UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint( macLoginUrlAuthenticationEntryPoint()).accessDeniedHandler(new PoseidonAccessDeniedHandler());
    }

    protected AuthenticationManager getAuthenticationManager()  {
        ProviderManager authenticationManager = new ProviderManager(Arrays.asList(poseidonAuthenticationProvider(),daoAuthenticationProvider()));
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
        poseidonTokenFilter.setAuthenticationManager(getAuthenticationManager());
        poseidonTokenFilter.setFilterProcessesUrl(properties.getProcesses());
        return poseidonTokenFilter;
    }

    public AuthenticationEntryPoint macLoginUrlAuthenticationEntryPoint() {
        return new PoseidonLoginUrlAuthenticationEntryPoint(properties.getProcesses());
    }

    public AccessDecisionManager accessDecisionManager(){
        List<AccessDecisionVoter<? extends Object>> decisionVoters
                = Arrays.asList(
                new PoseidonExpressionVoter(),
                new WebExpressionVoter(),
                new RoleVoter(),
                new AuthenticatedVoter());
        return new UnanimousBased(decisionVoters);

    }
}
