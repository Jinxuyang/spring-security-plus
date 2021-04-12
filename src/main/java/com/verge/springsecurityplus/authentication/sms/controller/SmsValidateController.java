package com.verge.springsecurityplus.authentication.sms.controller;

import com.verge.springsecurityplus.authentication.sms.component.SmsValidateCodeSender;
import com.verge.springsecurityplus.authentication.sms.dto.SmsCode;
import com.verge.springsecurityplus.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

/**
 * @Author Verge
 * @Date 2021/4/11 16:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/sms")
public class SmsValidateController {

    @Autowired
    private SmsValidateCodeSender smsValidateCodeSender;

    @GetMapping("/")
    public R getSmsValidateCode(@RequestParam String mobile) throws AuthenticationException {
        SmsCode smsCode = smsValidateCodeSender.send(mobile);
        if (smsCode.isSuccess()){
            return R.ok("发送成功");
        } else {
            return R.error("发送失败");
        }
    }
}
