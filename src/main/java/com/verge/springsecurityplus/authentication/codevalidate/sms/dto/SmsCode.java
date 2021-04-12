package com.verge.springsecurityplus.authentication.codevalidate.sms.dto;



/**
 * @Author Verge
 * @Date 2021/4/11 17:06
 * @Version 1.0
 */
public class SmsCode {
    private String code;

    public SmsCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
