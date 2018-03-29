package com.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** 添加@RestControllerAdvice 注解 **/
@RestControllerAdvice
public class RestControllerExceptionHandlerAdvice {

    public static final Logger log = LoggerFactory.getLogger(RestControllerExceptionHandlerAdvice.class);

    /** 访问权限不足 **/
    @ExceptionHandler(value = {UnauthorizedException.class})
    public Map<String, Object> UnauthorizedException(UnauthorizedException ue) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", 500);
        map.put("msg", "访问权限不足:" + ue.getMessage());
        return map;
    }

    /** 没有登陆系统 **/
    @ExceptionHandler(value = {UnauthenticatedException.class})
    public Map<String, Object> UnauthenticatedException(UnauthenticatedException ue) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", 500);
        map.put("msg", "验证信息失效,请重新登陆系统!");
        return map;
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> myErrorHandler(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", 500);
        map.put("msg", ex.getMessage());
        log.error(ex.getMessage());
        return map;
    }

}
