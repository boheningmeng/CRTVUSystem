package cn.lh.security;

import cn.lh.pojo.User;
import cn.lh.service.RoleService;
import cn.lh.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LENOVO on 2017/9/19.
 */
 public class DefineRealm extends AuthorizingRealm {
     @Autowired
     UserInfoService userService;
     @Autowired
    RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始授予权限...");
        String   username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        User user = userService.getUserByNumber(username);
        Set<String> roleSet = new HashSet<>();
        roleSet.add(String.valueOf(user.getRoleid()));

        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(roleService.getPermissionByRid(user.getRoleid()));
        System.out.println(roleService.getPermissionByRid(user.getRoleid()));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录验证中。。。。。");
        String userNumber = (String) authenticationToken.getPrincipal();
        User user = userService.getUserByNumber(userNumber);
        if(user==null){
            throw  new UnknownAccountException();//没找到账号
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getNumber(),
                user.getPassword(),
                user.getUsername()
        );
      return authenticationInfo;
    }


}
