package com.verge.springsecurityplus.authentication.validatecode.dto;

import java.awt.image.BufferedImage;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author Verge
 * @Date 2021/4/9 12:27
 * @Version 1.0
 */
public class ImageCode {

    private String code;

    private Long expireTime;

    public ImageCode(String code, long expireIn) {
        this.code = code;
        this.expireTime = System.currentTimeMillis() + expireIn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
