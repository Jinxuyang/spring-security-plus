package com.verge.springsecurityplus.authentication.sms.config;

import com.verge.springsecurityplus.authentication.sms.component.DefaultSmsValidateCodeSender;
import com.verge.springsecurityplus.authentication.sms.component.SmsValidateCodeSender;
import com.verge.springsecurityplus.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author Verge
 * @Date 2021/4/11 17:10
 * @Version 1.0
 */
@Configuration
public class SmsValidateCodeBeanConfig {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private SecurityProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public SmsValidateCodeSender smsValidateCodeSender(){
        return new DefaultSmsValidateCodeSender(redisTemplate,properties);
    }
}