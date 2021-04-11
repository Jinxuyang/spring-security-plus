package com.verge.springsecurityplus.authentication.imagevalidatecode.service;

import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

/**
 * @Author Verge
 * @Date 2021/4/9 12:53
 * @Version 1.0
 */
@Service
public interface ImageCodeService {
    BufferedImage generateImageCode(String uuid);
}
