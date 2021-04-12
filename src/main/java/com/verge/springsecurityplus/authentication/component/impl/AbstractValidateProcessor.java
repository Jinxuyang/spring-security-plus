package com.verge.springsecurityplus.authentication.component.impl;

import com.verge.springsecurityplus.authentication.component.ValidateProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Verge
 * @Date 2021/4/12 17:13
 * @Version 1.0
 */
public abstract class AbstractValidateProcessor implements ValidateProcessor {
    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) {

    }
}
