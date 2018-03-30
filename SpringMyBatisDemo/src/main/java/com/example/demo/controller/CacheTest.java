package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.util.CacheUtil;

@RestController
@RequestMapping("/cache")
public class CacheTest {

    @RequestMapping("/list")
    public Object list() {
        Map<String, Object> map = new HashMap<>();
        map.put("authorization", readCache(CacheUtil.getAuthorizationCache()));
        map.put("KickOut", readCache(CacheUtil.getKickOutCache()));
        map.put("PasswordRetry", readCache(CacheUtil.getPasswordRetryCache()));
        map.put("TokenAuthentication", readCache(CacheUtil.getTokenAuthenticationCache()));
        map.put("UpAuthentication", readCache(CacheUtil.getUpAuthenticationCache()));
        return map;
    }

    private Object readCache(Cache cache) {
        Map<Object, Object> m = new HashMap<>();
        cache.keys().forEach(k -> {
            m.put(k, cache.get(k));
        });

        return m;
    }


    @RequestMapping("/delete")
    public Object delete() {
        String un = "develop";
        CacheUtil.clearAuthenticationCache(un);
        CacheUtil.clearAuthorizationCache(un);

        return list();
    }

}
