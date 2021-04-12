package com.verge.springsecurityplus.authentication.codevalidate.sms.component;

import com.verge.springsecurityplus.authentication.codevalidate.sms.dto.SmsCode;

/**
 * @Author Verge
 * @Date 2021/4/12 17:34
 * @Version 1.0
 */
public interface SmsValidateCodeGenerator {
    SmsCode generate();
}
