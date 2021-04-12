package com.verge.springsecurityplus.authentication.codevalidate.config;

import com.verge.springsecurityplus.authentication.codevalidate.image.component.DefaultImageValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.image.component.ImageValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.SmsValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.SmsValidateCodeSender;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.impl.DefaultSmsValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.impl.DefaultSmsValidateCodeSender;
import com.verge.springsecurityplus.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Verge
 * @Date 2021/4/12 17:54
 * @Version 1.0
 */
@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public SmsValidateCodeSender smsValidateCodeSender(){
        return new DefaultSmsValidateCodeSender();
    }

    @Bean
    @ConditionalOnMissingBean
    public SmsValidateCodeGenerator smsValidateCodeGenerator(){
        return new DefaultSmsValidateCodeGenerator(properties);
    }

    @Bean
    @ConditionalOnMissingBean
    public ImageValidateCodeGenerator imageValidateCodeGenerator(){
        return new DefaultImageValidateCodeGenerator(properties);
    }
}
