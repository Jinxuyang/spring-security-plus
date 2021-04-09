package com.verge.springsecurityplus.authentication.sms.component;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author Verge
 * @Date 2021/4/8 20:57
 * @Version 1.0
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;

    /**
     * 身份认证逻辑
     * @param authentication 未经校验的authentication
     * @return 通过校验的authentication
     * @throws AuthenticationException 校验失败抛出异常
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken authenticationToken = (SmsAuthenticationToken) userDetailsService;

        // 根据手机号读取用户信息
        UserDetails user = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
        /*
        *  校验逻辑：
        *   成功返回经过校验的Authentication,并复制原authentication的Details信息
        *   否则抛出AuthenticationException
        *
        * */
        return null;
    }

    /**
     * 判断该provider是否支持校验此authentication
     * @param authentication 传进来的authentication
     * @return 该provider是否支持校验此authentication
     */
    @Override
    public boolean supports(Class<?> authentication) {
        //判断authentication是不是SmsAuthenticationToken这个类型
        return SmsAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
