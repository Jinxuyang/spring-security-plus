package com.verge.springsecurityplus.authentication.codevalidate.sms.properties;

/**
 * @Author Verge
 * @Date 2021/4/11 16:42
 * @Version 1.0
 */
public class SmsValidateCodeProperties {
    int length = 4;
    int expireIn = 60;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
