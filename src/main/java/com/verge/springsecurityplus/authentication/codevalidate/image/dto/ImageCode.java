package com.verge.springsecurityplus.authentication.codevalidate.image.dto;

import com.verge.springsecurityplus.authentication.codevalidate.sms.dto.SmsCode;

import java.awt.image.BufferedImage;

/**
 * @Author Verge
 * @Date 2021/4/11 16:58
 * @Version 1.0
 */
public class ImageCode extends SmsCode {
    BufferedImage image;

    public ImageCode(BufferedImage image,String code) {
        super(code);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
