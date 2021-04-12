package com.verge.springsecurityplus.authentication.codevalidate.sms.component.impl;

import com.verge.springsecurityplus.authentication.codevalidate.sms.component.SmsValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.sms.dto.SmsCode;
import com.verge.springsecurityplus.properties.SecurityProperties;

import java.util.Random;

/**
 * @Author Verge
 * @Date 2021/4/12 17:36
 * @Version 1.0
 */
public class DefaultSmsValidateCodeGenerator implements SmsValidateCodeGenerator {
    private SecurityProperties properties;

    public DefaultSmsValidateCodeGenerator(SecurityProperties properties) {
        this.properties = properties;
    }

    @Override
    public SmsCode generate() {
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        int length = properties.getSmsValidateCode().getLength();
        for (int i = 0; i < length; i++) {
            buffer.append(chars[random.nextInt(10)]);
        }
        return new SmsCode(buffer.toString(),true);
    }
}
