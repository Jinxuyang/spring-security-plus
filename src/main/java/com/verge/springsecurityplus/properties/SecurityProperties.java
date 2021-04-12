package com.verge.springsecurityplus.properties;

import com.verge.springsecurityplus.authentication.image.properties.ImageValidateCodeProperties;
import com.verge.springsecurityplus.authentication.sms.properties.SmsValidateCodeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @Author Verge
 * @Date 2021/4/9 16:09
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "spring.security-plus")
public class SecurityProperties {
    @NestedConfigurationProperty
    private ImageValidateCodeProperties imageValidateCode = new ImageValidateCodeProperties();

    @NestedConfigurationProperty
    private SmsValidateCodeProperties smsValidateCode = new SmsValidateCodeProperties();

    public ImageValidateCodeProperties getImageValidateCode() {
        return imageValidateCode;
    }

    public void setImageValidateCode(ImageValidateCodeProperties imageValidateCode) {
        this.imageValidateCode = imageValidateCode;
    }

    public SmsValidateCodeProperties getSmsValidateCode() {
        return smsValidateCode;
    }

    public void setSmsValidateCode(SmsValidateCodeProperties smsValidateCode) {
        this.smsValidateCode = smsValidateCode;
    }
}
