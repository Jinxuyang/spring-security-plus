package com.verge.springsecurityplus.authentication.image.controller;

import com.verge.springsecurityplus.authentication.image.component.ImageValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.image.dto.ImageCode;
import com.verge.springsecurityplus.constant.RedisConstant;
import com.verge.springsecurityplus.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Verge
 * @Date 2021/4/9 12:45
 * @Version 1.0
 */
@RestController
public class ValidateCodeController {

    @Autowired
    private ImageValidateCodeGenerator generator;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private SecurityProperties properties;

    /**
     * 获取图形验证码的图
     * @param uuid 用户提供一个uuid
     */
    @GetMapping("/code/image")
    public void createCode(HttpServletResponse response,String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        ImageCode image = generator.generateImageCode(uuid);

        int expireIn = properties.getImageValidateCode().getExpireIn();
        redisTemplate.opsForValue().set(RedisConstant.UUID_CODE+uuid, image.getCode(), expireIn, TimeUnit.SECONDS);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image.getImage(), "jpg", out);
        out.close();
    }
}
