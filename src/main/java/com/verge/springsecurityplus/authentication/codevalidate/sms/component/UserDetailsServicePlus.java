package com.verge.springsecurityplus.authentication.codevalidate.sms.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author Verge
 * @Date 2021/4/11 19:49
 * @Version 1.0
 */
public interface UserDetailsServicePlus extends UserDetailsService {
    UserDetailsPlus loadUserByMobile(String mobile) throws AuthenticationException;
}
