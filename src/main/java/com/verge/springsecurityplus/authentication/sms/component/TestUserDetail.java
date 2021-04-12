package com.verge.springsecurityplus.authentication.sms.component;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author Verge
 * @Date 2021/4/11 21:34
 * @Version 1.0
 */
public class TestUserDetail extends User implements UserDetailsPlus {
    private String mobile;

    public TestUserDetail(String username, String password,String mobile, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
