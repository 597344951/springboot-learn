package com.example.redistest.service;

public interface RedisTestService {
    
    public void saveStr(String key,String value);
    
    public String readStr(String key);

}
