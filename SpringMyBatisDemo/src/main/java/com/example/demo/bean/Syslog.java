package com.example.demo.bean;

public class Syslog {
    private String username;
    private String operation;
    private String method;
    private String params;
    private String ip;

    /**
     * 获取username
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置username
     * 
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取operation
     * 
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置operation
     * 
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 获取method
     * 
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置method
     * 
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取params
     * 
     * @return the params
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置params
     * 
     * @param params the params to set
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取ip
     * 
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip
     * 
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}
