package com.verge.springsecurityplus.authentication.codevalidate.image.config;

import com.verge.springsecurityplus.authentication.codevalidate.image.component.ImageValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.image.component.DefaultImageValidateCodeGenerator;
import com.verge.springsecurityplus.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Verge
 * @Date 2021/4/11 15:27
 * @Version 1.0
 */
@Configuration
public class ImageValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public ImageValidateCodeGenerator imageValidateCodeGenerator(){
        return new DefaultImageValidateCodeGenerator(properties);
    }
}
