package com.verge.springsecurityplus.authentication.codevalidate.sms.token;

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
    private final String credentials;

    /**
     * 构造一个未经验证的SmsAuthenticationToken
     * @param mobile 手机号
     */
    public SmsAuthenticationToken(String mobile,String code) {
        super(null);
        this.principal = mobile;
        this.credentials = code;
        setAuthenticated(false);
    }

    /**
     * 构造一个经过验证的SmsAuthenticationToken
     * @param principal 用户信息
     * @param authorities 用户权限
     * @param credentials
     */
    public SmsAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities, String credentials) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    @Override
    public String getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
