package com.verge.springsecurityplus.authentication.image.component;

import com.verge.springsecurityplus.authentication.image.dto.ImageCode;

import java.awt.image.BufferedImage;

/**
 * @Author Verge
 * @Date 2021/4/11 15:21
 * @Version 1.0
 */
public interface ImageValidateCodeGenerator {
    ImageCode generateImageCode(String uuid);
}
