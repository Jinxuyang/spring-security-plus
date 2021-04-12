package com.verge.springsecurityplus.authentication.sms.component.impl;

import com.verge.springsecurityplus.authentication.sms.component.SmsValidateCodeSender;
import com.verge.springsecurityplus.authentication.sms.dto.SmsCode;
import com.verge.springsecurityplus.properties.SecurityProperties;

import javax.naming.AuthenticationException;

/**
 * @Author Verge
 * @Date 2021/4/11 16:27
 * @Version 1.0
 */
public class DefaultSmsValidateCodeSender implements SmsValidateCodeSender {

    @Override
    public boolean send(String mobile, String code) throws AuthenticationException {

        /*
        * 发送逻辑
        * */
        System.out.println("向" + mobile + "发送短信, 验证码为：" + code);

        return true;
    }
}
