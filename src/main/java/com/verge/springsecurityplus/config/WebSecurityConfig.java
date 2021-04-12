package com.verge.springsecurityplus.config;


import com.verge.springsecurityplus.authentication.codevalidate.image.filter.ImageValidateCodeFilter;
import com.verge.springsecurityplus.authentication.codevalidate.sms.config.SmsAuthenticationSecurityConfig;
import com.verge.springsecurityplus.component.RestfulAuthenticationFailureHandler;
import com.verge.springsecurityplus.component.RestfulAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Author Verge
 * @Date 2021/4/8 19:13
 * @Version 1.0
 */
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ImageValidateCodeFilter imageValidateCodeFilter;

    @Autowired
    private RestfulAuthenticationFailureHandler restfulAuthenticationFailureHandler;

    @Autowired
    private RestfulAuthenticationSuccessHandler restfulAuthenticationSuccessHandler;

    @Autowired
    private SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        imageValidateCodeFilter.setAuthenticationFailureHandler(restfulAuthenticationFailureHandler);
        http.addFilterBefore(imageValidateCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler(restfulAuthenticationSuccessHandler)
                .failureHandler(restfulAuthenticationFailureHandler);
        http.authorizeRequests()
                .antMatchers("/code/image","/login")
                .permitAll();
        http.csrf().disable();
        http.apply(smsAuthenticationSecurityConfig);
    }
}
