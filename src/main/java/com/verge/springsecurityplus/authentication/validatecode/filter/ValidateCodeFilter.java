package com.verge.springsecurityplus.authentication.validatecode.filter;

import com.verge.springsecurityplus.authentication.validatecode.dto.ImageCode;
import com.verge.springsecurityplus.component.RestfulAuthenticationFailureHandler;
import com.verge.springsecurityplus.constant.RedisConstant;
import com.verge.springsecurityplus.exception.ValidateCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Verge
 * @Date 2021/4/8 19:09
 * @Version 1.0
 */
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ("/login".equals(request.getRequestURI()) && "POST".equals(request.getMethod())){
            try {
                validate(request);
            } catch (ValidateCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(request,response,e);
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    private void validate(HttpServletRequest request) throws ServletRequestBindingException {
        String uuid = ServletRequestUtils.getStringParameter(request,"uuid");
        String userCode = ServletRequestUtils.getStringParameter(request,"code");
        if (userCode == null) {
            throw new ValidateCodeException("验证码不能为空");
        }

        String code = (String) redisTemplate.opsForValue().get(RedisConstant.UUID_CODE+uuid);
        if (code == null){
            throw new ValidateCodeException("验证码已过期，请刷新");
        }

        if (!code.equalsIgnoreCase(userCode)){
            throw new ValidateCodeException("验证码不匹配");
        }

        redisTemplate.delete(RedisConstant.UUID_CODE+uuid);
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }
}
