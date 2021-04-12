package com.verge.springsecurityplus.authentication.codevalidate.controller;

import com.verge.springsecurityplus.authentication.codevalidate.image.component.ImageValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.image.dto.ImageCode;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.SmsValidateCodeGenerator;
import com.verge.springsecurityplus.authentication.codevalidate.sms.component.SmsValidateCodeSender;
import com.verge.springsecurityplus.authentication.codevalidate.sms.dto.SmsCode;
import com.verge.springsecurityplus.common.R;
import com.verge.springsecurityplus.constant.RedisConstant;
import com.verge.springsecurityplus.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.naming.AuthenticationException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Verge
 * @Date 2021/4/12 17:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/code")
public class ValidateCodeController {

    @Autowired
    private ImageValidateCodeGenerator imageValidateCodeGenerator;

    @Autowired
    private SmsValidateCodeGenerator smsValidateCodeGenerator;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private SecurityProperties properties;

    @Autowired
    private SmsValidateCodeSender smsValidateCodeSender;

    /**
     * 获取图形验证码的图
     * @param uuid 用户提供一个uuid
     */
    @GetMapping("/image")
    public void getImageValidateCode(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 创建
        ImageCode image = imageValidateCodeGenerator.generate(uuid);

        // 保存
        int expireIn = properties.getImageValidateCode().getExpireIn();
        redisTemplate.opsForValue().set(RedisConstant.UUID_CODE+uuid, image.getCode(), expireIn, TimeUnit.SECONDS);

        // 发送
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image.getImage(), "jpg", out);
        out.close();
    }



    @GetMapping("/sms")
    public R getSmsValidateCode(@RequestParam String mobile) throws AuthenticationException {
        SmsCode smsCode = smsValidateCodeGenerator.generate();

        int expireIn = properties.getSmsValidateCode().getExpireIn();
        redisTemplate.opsForValue().set(RedisConstant.MOBILE_CODE+mobile, smsCode.getCode(), expireIn, TimeUnit.SECONDS);

        smsValidateCodeSender.send(mobile, smsCode.getCode());

        return R.ok("发送成功");

    }
}
