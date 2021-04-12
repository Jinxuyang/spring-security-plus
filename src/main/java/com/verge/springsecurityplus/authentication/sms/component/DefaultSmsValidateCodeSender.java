package com.verge.springsecurityplus.authentication.sms.component;

import com.verge.springsecurityplus.authentication.sms.dto.SmsCode;
import com.verge.springsecurityplus.properties.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;

import javax.naming.AuthenticationException;
import java.util.Random;

/**
 * @Author Verge
 * @Date 2021/4/11 16:27
 * @Version 1.0
 */
public class DefaultSmsValidateCodeSender implements SmsValidateCodeSender {

    private SecurityProperties properties;


    public DefaultSmsValidateCodeSender(SecurityProperties properties) {
        this.properties = properties;
    }

    @Override
    public SmsCode send(String mobile) throws AuthenticationException {

        String code = getRandomChar(properties.getSmsValidateCode().getLength());

        /*
        * 发送逻辑
        * */
        System.out.println("向" + mobile + "发送短信, 验证码为：" + code);

        return new SmsCode(code, true);
    }

    public static String getRandomChar(int length) {
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buffer.append(chars[random.nextInt(10)]);
        }
        return buffer.toString();
    }

    public void setProperties(SecurityProperties properties) {
        this.properties = properties;
    }
}
