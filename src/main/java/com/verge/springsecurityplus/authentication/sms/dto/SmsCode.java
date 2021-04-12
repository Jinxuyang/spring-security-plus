package com.verge.springsecurityplus.authentication.sms.dto;

/**
 * @Author Verge
 * @Date 2021/4/11 17:06
 * @Version 1.0
 */
public class SmsCode {
    private String code;

    private boolean isSuccess;

    public SmsCode(String code, boolean isSuccess) {
        this.code = code;
        this.isSuccess = isSuccess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
