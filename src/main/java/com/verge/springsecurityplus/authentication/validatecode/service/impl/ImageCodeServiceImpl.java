package com.verge.springsecurityplus.authentication.validatecode.service.impl;

import com.verge.springsecurityplus.authentication.validatecode.service.ImageCodeService;
import com.verge.springsecurityplus.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Author Verge
 * @Date 2021/4/9 12:53
 * @Version 1.0
 */
@Service
public class ImageCodeServiceImpl implements ImageCodeService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public BufferedImage generateImageCode(String uuid) {
        int width = 60;
        int height = 20;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //生成随机验证码，字符从chars中选取，chars可随意定义
        String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] rands=new char[4];
        for(int i=0;i<4;i++)
        {
            int rand=(int)(Math.random()*36);
            rands[i]=chars.charAt(rand);
        }
        //生成图画，背景
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        for(int i=0;i<120;i++)
        {
            int x=(int)(Math.random()*width);
            int y=(int)(Math.random()*height);
            int red=(int)(Math.random()*255);
            int green=(int)(Math.random()*255);
            int blue=(int)(Math.random()*255);
            g.setColor(new Color(red,green,blue));
            g.drawOval(x, y, 1, 0);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.ITALIC|Font.BOLD,18));
        //在不同位置输出验证码的字符
        g.drawString(""+rands[0], 1, 17);
        g.drawString(""+rands[1], 16, 15);
        g.drawString(""+rands[2], 31, 18);
        g.drawString(""+rands[3], 46, 16);

        String code = String.copyValueOf(rands);
        redisTemplate.opsForValue().set(RedisConstant.UUID_CODE+uuid, code, 6000, TimeUnit.SECONDS);

        return image;
    }
}
