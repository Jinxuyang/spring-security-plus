package com.verge.springsecurityplus.authentication.codevalidate.sms.config;

import com.verge.springsecurityplus.authentication.codevalidate.sms.component.impl.DefaultUserDetailsServicePlus;
import com.verge.springsecurityplus.authentication.codevalidate.sms.provider.SmsAuthenticationProvider;
import com.verge.springsecurityplus.authentication.codevalidate.sms.filter.SmsAuthenticationFilter;
import com.verge.springsecurityplus.component.RestfulAuthenticationFailureHandler;
import com.verge.springsecurityplus.component.RestfulAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author Verge
 * @Date 2021/4/11 19:23
 * @Version 1.0
 */
@Configuration
public class SmsAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private RestfulAuthenticationSuccessHandler successHandler;

    @Autowired
    private RestfulAuthenticationFailureHandler failureHandler;

    @Autowired
    private DefaultUserDetailsServicePlus userDetailsService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public void configure(HttpSecurity http) {
        SmsAuthenticationFilter filter = new SmsAuthenticationFilter();
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        filter.setAuthenticationSuccessHandler(successHandler);
        filter.setAuthenticationFailureHandler(failureHandler);

        SmsAuthenticationProvider provider = new SmsAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setRedisTemplate(redisTemplate);

        http.authenticationProvider(provider)
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);

    }
}
