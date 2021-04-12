package com.verge.springsecurityplus.authentication.sms.component;

import com.verge.springsecurityplus.authentication.sms.dto.SmsCode;

import javax.naming.AuthenticationException;

/**
 * @Author Verge
 * @Date 2021/4/11 16:26
 * @Version 1.0
 */
public interface SmsValidateCodeSender {
    SmsCode send(String mobile) throws AuthenticationException;
}
