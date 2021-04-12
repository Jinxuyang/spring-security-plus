package com.verge.springsecurityplus.authentication.image.dto;

import java.awt.image.BufferedImage;

/**
 * @Author Verge
 * @Date 2021/4/11 16:58
 * @Version 1.0
 */
public class ImageCode {
    BufferedImage image;

    String code;

    public ImageCode(BufferedImage image, String code) {
        this.image = image;
        this.code = code;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
