package com.verge.springsecurityplus.authentication.codevalidate.sms.component;

import javax.naming.AuthenticationException;

/**
 * @Author Verge
 * @Date 2021/4/11 16:26
 * @Version 1.0
 */
public interface SmsValidateCodeSender {
    void send(String mobile, String code) throws AuthenticationException;
}
