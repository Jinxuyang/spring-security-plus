package com.verge.springsecurityplus.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @Author Verge
 * @Date 2021/4/8 19:17
 * @Version 1.0
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
