package com.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordHelper {
    private static String algorithmName = "md5";
    private static int hashIterations = 2;
    
    public static String encryptPassword(String psin, String un, String salt) {
        SimpleHash hash = new SimpleHash(algorithmName, psin, salt, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }
    

    /**
     * 获取algorithmName  
     * @return the algorithmName
     */
    public static String getAlgorithmName() {
        return algorithmName;
    }

    /**
     * 设置algorithmName  
     * @param algorithmName the algorithmName to set
     */
    public static void setAlgorithmName(String algorithmName) {
        PasswordHelper.algorithmName = algorithmName;
    }

    /**
     * 获取hashIterations  
     * @return the hashIterations
     */
    public static int getHashIterations() {
        return hashIterations;
    }

    /**
     * 设置hashIterations  
     * @param hashIterations the hashIterations to set
     */
    public static void setHashIterations(int hashIterations) {
        PasswordHelper.hashIterations = hashIterations;
    }
    
}
