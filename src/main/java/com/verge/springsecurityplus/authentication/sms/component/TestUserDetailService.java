package com.verge.springsecurityplus.authentication.sms.component;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Verge
 * @Date 2021/4/11 19:54
 * @Version 1.0
 */
@Service
public class TestUserDetailService extends InMemoryUserDetailsManager implements UserDetailsServicePlus {
    @Override
    public UserDetailsPlus loadUserByMobile(String mobile) throws AuthenticationException {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("user"));
        return new TestUserDetail("test","test","17765014581",list);
    }
}
