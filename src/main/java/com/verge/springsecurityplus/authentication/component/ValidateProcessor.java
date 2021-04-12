package com.verge.springsecurityplus.authentication.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Verge
 * @Date 2021/4/12 17:09
 * @Version 1.0
 */
public interface ValidateProcessor {

    void create(HttpServletRequest request, HttpServletResponse response);
}
