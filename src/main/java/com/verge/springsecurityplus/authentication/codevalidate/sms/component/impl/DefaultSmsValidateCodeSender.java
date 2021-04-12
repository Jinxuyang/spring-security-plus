package com.verge.springsecurityplus.authentication.codevalidate.sms.component.impl;

import com.verge.springsecurityplus.authentication.codevalidate.sms.component.SmsValidateCodeSender;

import javax.naming.AuthenticationException;

/**
 * @Author Verge
 * @Date 2021/4/11 16:27
 * @Version 1.0
 */
public class DefaultSmsValidateCodeSender implements SmsValidateCodeSender {

    @Override
    public void send(String mobile, String code) throws AuthenticationException {

        /*
        * 发送逻辑
        * */
        System.out.println("向" + mobile + "发送短信, 验证码为：" + code);

    }
}
