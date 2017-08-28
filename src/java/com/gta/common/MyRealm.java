package com.gta.common;

import com.gta.model.User;
import com.gta.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * MyRealm 功能： 自定义realm
 * created by ningning.jiang 2017-08-14 10:53:47
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = Logger.getLogger(MyRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LOGGER.info("--- MyRealm doGetAuthenticationInfo ---");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String userName = upToken.getPrincipal().toString();
        User user = userService.getUserByName(userName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassWord(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(userName.getBytes()));
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.info("--- MyRealm doGetAuthorizationInfo ---");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        String userName = user.getUserName();
        if (userName != null && "admin".equals(userName)){
            info.addRole("admin");
            info.addStringPermission("admin:manage");
            return info;
        }
        if (userName != null && "teaManage".equals(userName)){
            info.addRole("teaManage");
            info.addRole("tea");
            info.addStringPermission("tea:manage");
            return info;
        }
        if (userName != null && "tea".equals(userName)){
            info.addRole("tea");
            return info;
        }
        if (userName != null && "stu".equals(userName)){
            info.addRole("stu");
            return info;
        }
        return info;
    }
}
