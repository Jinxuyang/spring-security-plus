package com.verge.springsecurityplus.authentication.codevalidate.sms.component.impl;

import com.verge.springsecurityplus.authentication.codevalidate.sms.component.UserDetailsPlus;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.UserDetailsServicePlus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

/**
 * @Author Verge
 * @Date 2021/4/12 18:12
 * @Version 1.0
 */
@Component
public class DefaultUserDetailsServicePlus extends InMemoryUserDetailsManager implements UserDetailsServicePlus {

    @Override
    public UserDetailsPlus loadUserByMobile(String mobile) throws AuthenticationException {
        logger.error("请实现UserDetailsServicePlus接口后使用验证码登录");
        return null;
    }
}
