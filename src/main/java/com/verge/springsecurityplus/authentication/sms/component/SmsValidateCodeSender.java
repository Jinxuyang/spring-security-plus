package com.verge.springsecurityplus.authentication.sms.component;

import javax.naming.AuthenticationException;

/**
 * @Author Verge
 * @Date 2021/4/11 16:26
 * @Version 1.0
 */
public interface SmsValidateCodeSender {
    boolean send(String mobile,String code) throws AuthenticationException;
}
