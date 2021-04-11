package com.verge.springsecurityplus.authentication.imagevalidatecode.component;

import java.awt.image.BufferedImage;

/**
 * @Author Verge
 * @Date 2021/4/11 15:21
 * @Version 1.0
 */
public interface ImageValidateCodeGenerator {
    BufferedImage generateImageCode(String uuid);
}
