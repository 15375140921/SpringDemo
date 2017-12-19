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

    /**
     * 验证当前登录的Subject
     * 经测试：本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()的时候
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LOGGER.info("--- MyRealm doGetAuthenticationInfo ---");
        /*获取基于用户名和密码的令牌
        实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        两个token的引用都是一样的，本例中是：org.apache.shiro.authc.UsernamePasswordToken@33799a1e*/
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String userName = upToken.getPrincipal().toString();
        User user = userService.getUserByName(userName);
        /*此处无需比对，比对的逻辑Shiro会做，我们只需返回一个和令牌相关的正确的验证信息
        说白了就是第一个参数填登录用户名，第二个参数填合法的登录密码（可以是从数据库中取到的）
        这样一来，在随后的登录页面上就只有这里指定的用户和密码才能通过验证*/
        //SimpleAuthenticationInfo info1 = new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(), getName());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassWord(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(userName.getBytes()));
        return info;
    }


    /**
     * 为当前登录的Subject授予角色和权限
     * -----------------------------------------------------------------------------------------------
     * 经测试：本例中该方法的调用时机为需授权资源被访问时
     * 经测试：并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
     * 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持，则可灵活决定是否启用AuthorizationCache
     * 比如说这里从数据库获取权限信息时，先去访问Spring3.1提供的缓存，而不使用Shiro提供的AuthorizationCache
     * -----------------------------------------------------------------------------------------------
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.info("--- MyRealm doGetAuthorizationInfo ---");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        String userName = user.getUserName();
        if (userName != null && "admin".equals(userName)) {
            info.addRole("admin");
            info.addStringPermission("admin:manage");
            return info;
        }
        if (userName != null && "teaManage".equals(userName)) {
            info.addRole("teaManage");
            info.addRole("tea");
            info.addStringPermission("tea:manage");
            return info;
        }
        if (userName != null && "tea".equals(userName)) {
            info.addRole("tea");
            info.addStringPermission("tea:update");
            return info;
        }
        if (userName != null && "stu".equals(userName)) {
            info.addRole("stu");
            return info;
        }
        return info;
    }
}
