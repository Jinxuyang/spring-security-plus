package com.verge.springsecurityplus.authentication.sms.component;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author Verge
 * @Date 2021/4/11 21:41
 * @Version 1.0
 */
public interface UserDetailsPlus extends UserDetails {
    String getMobile();
}
