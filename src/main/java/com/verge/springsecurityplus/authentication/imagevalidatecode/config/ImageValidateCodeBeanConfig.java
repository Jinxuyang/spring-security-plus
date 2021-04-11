package com.verge.springsecurityplus.authentication.imagevalidatecode.config;

import com.verge.springsecurityplus.authentication.imagevalidatecode.component.ImageValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.imagevalidatecode.component.ImageValidateCodeGeneratorImpl;
import com.verge.springsecurityplus.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author Verge
 * @Date 2021/4/11 15:27
 * @Version 1.0
 */
@Configuration
public class ImageValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties properties;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Bean
    @ConditionalOnMissingBean
    public ImageValidateCodeGenerator imageValidateCodeGenerator(){
        return new ImageValidateCodeGeneratorImpl(properties,redisTemplate);
    }
}
