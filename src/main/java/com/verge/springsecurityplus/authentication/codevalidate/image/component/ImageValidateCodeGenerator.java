package com.verge.springsecurityplus.authentication.codevalidate.image.component;

import com.verge.springsecurityplus.authentication.codevalidate.image.dto.ImageCode;

/**
 * @Author Verge
 * @Date 2021/4/11 15:21
 * @Version 1.0
 */
public interface ImageValidateCodeGenerator {
    ImageCode generate(String uuid);
}
