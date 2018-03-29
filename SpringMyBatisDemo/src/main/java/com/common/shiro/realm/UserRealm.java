package com.common.shiro.realm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.common.shiro.authc.MyToken;
import com.common.util.PasswordHelper;

public class UserRealm extends AuthorizingRealm {

    /** 日志输出对象 **/
    public static final Log logout = LogFactory.getLog(UserRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        logout.info("查找" + username + " 权限");
        Set<String> roles = new HashSet<>(Arrays.asList("admin"));
        Set<String> premis = new HashSet<>(Arrays.asList("org:add", "org:update", "org:delete"));
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(premis);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        logout.info("尝试使用 用户名/密码方式登陆");
        MyToken mt = (MyToken) token;
        if (mt.getLoginType() != 0) return null;

        String username = (String) token.getPrincipal();
        if (username == null) {
            throw new UnknownAccountException();// 没找到帐号
        }

        String ps = "123456";
        String nps = PasswordHelper.encryptPassword(ps, username, username);
        // 如果身份认证验证成功，返回一个AuthenticationInfo实现；
        String salt = username;
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, // 用户名
                nps, // 密码
                ByteSource.Util.bytes(salt), // salt=username
                getName() // realm name
        );
        // authenticationInfo = new SimpleAuthenticationInfo(username,ps,getName());

        return authenticationInfo;


    }

}
