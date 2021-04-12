package com.verge.springsecurityplus.authentication.sms.component.impl;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 模仿UsernamePasswordAuthenticationToken实现SmsAuthenticationToken
 * @Author Verge
 * @Date 2021/4/8 20:28
 * @Version 1.0
 */
public class SmsAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    /**
     * 构造一个未经验证的SmsAuthenticationToken
     * @param mobile 手机号
     */
    public SmsAuthenticationToken(String mobile) {
        super(null);
        this.principal = mobile;
        setAuthenticated(false);
    }

    /**
     * 构造一个经过验证的SmsAuthenticationToken
     * @param principal 用户信息
     * @param authorities 用户权限
     */
    public SmsAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
