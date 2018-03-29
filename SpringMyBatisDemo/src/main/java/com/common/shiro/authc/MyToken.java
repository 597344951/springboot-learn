package com.common.shiro.authc;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyToken extends UsernamePasswordToken {
    /** serialVersionUID:TODO
     */ 
    private static final long serialVersionUID = 1L;
    /** 登陆类型,0:默认，1:密匙登陆 **/
    private int loginType;

    public MyToken(final String username, final String password, int lt) {
        super(username, password != null ? password.toCharArray() : null, false, null);
        this.loginType = lt;
    }

    /**
     * 获取登陆类型0:默认，1:密匙登陆
     * 
     * @return the loginType
     */
    public int getLoginType() {
        return loginType;
    }


    /**
     * 设置登陆类型0:默认，1:密匙登陆
     * 
     * @param loginType the 登陆类型0:默认，1:密匙登陆 to set
     */
    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }



}
