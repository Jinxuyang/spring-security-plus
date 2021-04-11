package com.verge.springsecurityplus.authentication.imagevalidatecode.controller;

import com.verge.springsecurityplus.authentication.imagevalidatecode.component.ImageValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author Verge
 * @Date 2021/4/9 12:45
 * @Version 1.0
 */
@RestController
public class ValidateCodeController {

    @Autowired
    private ImageValidateCodeGenerator generator;

    /**
     * 获取图形验证码的图
     * @param uuid 用户提供一个uuid
     */
    @GetMapping("/code/image")
    public void createCode(HttpServletResponse response,String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        BufferedImage image = generator.generateImageCode(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.close();
    }
}
