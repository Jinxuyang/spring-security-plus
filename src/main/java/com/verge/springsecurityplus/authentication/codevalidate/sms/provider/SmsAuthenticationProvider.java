package com.verge.springsecurityplus.authentication.codevalidate.sms.provider;

import com.verge.springsecurityplus.authentication.codevalidate.sms.component.UserDetailsPlus;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.UserDetailsServicePlus;
import com.verge.springsecurityplus.authentication.codevalidate.sms.token.SmsAuthenticationToken;
import com.verge.springsecurityplus.constant.RedisConstant;
import com.verge.springsecurityplus.exception.ValidateCodeException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author Verge
 * @Date 2021/4/8 20:57
 * @Version 1.0
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsServicePlus userDetailsService;

    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 身份认证逻辑
     * @param authentication 未经校验的authentication
     * @return 通过校验的authentication
     * @throws AuthenticationException 校验失败抛出异常
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken authenticationToken = (SmsAuthenticationToken) authentication;

        // 根据手机号读取用户信息
        UserDetailsPlus user = userDetailsService.loadUserByMobile((String) authentication.getPrincipal());

        String mobile = (String) authenticationToken.getPrincipal();

        String code = (String) redisTemplate.opsForValue().get(RedisConstant.MOBILE_CODE+mobile);

        if (code == null){
            throw new ValidateCodeException("校验码不存在");
        }

        if (!authentication.getCredentials().equals(code)){
            throw new ValidateCodeException("校验码不匹配");
        }

        return new SmsAuthenticationToken(mobile,user.getAuthorities(),"");
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


    public void setUserDetailsService(UserDetailsServicePlus userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
