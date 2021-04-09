/*
package com.verge.springsecurityplus.authentication.sms.filter;

import com.verge.springsecurityplus.authentication.sms.component.SmsAuthenticationToken;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * 模仿UsernamePasswordAuthenticationFilter
 * @Author Verge
 * @Date 2021/4/8 20:38
 * @Version 1.0
 *//*

public class SmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    public static final String SPRING_SECURITY_FORM_MOBILE_KEY = "username";

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/login/mobile", "POST");

    private String mobileParameter = SPRING_SECURITY_FORM_MOBILE_KEY;

    private boolean postOnly = true;

    public SmsAuthenticationFilter() {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
    }

    public SmsAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        // 校验请求是否为POST
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String mobile = obtainMobile(request);
        mobile = (mobile != null) ? mobile : "";
        mobile = mobile.trim();

        SmsAuthenticationToken authRequest = new SmsAuthenticationToken(mobile);

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    */
/**
     * 从request中获取手机号
     * @param request 请求信息
     * @return
     *//*

    @Nullable
    protected String obtainMobile(HttpServletRequest request) {
        return request.getParameter(this.mobileParameter);
    }

    */
/**
     * 将请求信息存入SmsAuthenticationToken
     * @param request 请求信息
     * @param authRequest SmsAuthenticationToken
     *//*

    protected void setDetails(HttpServletRequest request, SmsAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public void setMobileParameter(String mobileParameter) {
        this.mobileParameter = mobileParameter;
    }
}
*/
