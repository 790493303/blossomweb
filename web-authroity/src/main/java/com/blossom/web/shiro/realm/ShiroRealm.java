package com.blossom.web.shiro.realm;


import com.blossom.web.model.UserEntity;
import com.blossom.web.service.IUserService;
import net.sf.json.JSONObject;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Blossom
 * @Description
 * @time 2017/3/7 10:57
 */
@Component("shiroRealm")
public class ShiroRealm extends AuthorizingRealm {

    @Resource(name = "userService")
    private IUserService userService;

    public ShiroRealm(){
        setName("UserRealm");
        setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
    }

    /**
     * @description 权限资源角色
     * @author Blossom
     * @DateTime 2017/3/7 11:03
     *
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        JSONObject json = new JSONObject();
        json.put("loginAccount",userName);
        //添加角色
        json = userService.queryUserRole(json);
        Set<String> roleSet = new HashSet<>();
        if (json.getInt("status") == 1){
            roleSet = (Set<String>) json.get("roleSet");
        }
        info.setRoles(roleSet);
        //添加权限
        json.put("loginAccount",userName);
        json = userService.queryUserAuthor(json);
        Set<String> author = new HashSet<>();
        if (json.getInt("status") == 1){
            author = (Set<String>)json.get("authorSet");
        }
        info.setStringPermissions(author);

        return info;
    }

    /**
     * @description 登录验证
     * @author Blossom
     * @DateTime 2017/3/7 11:03
     *
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String userName = usernamePasswordToken.getUsername();
        JSONObject json = new JSONObject();
        json.put("loginAccount",userName);
        json = userService.queryUserInfo(json);
        UserEntity userEntity = new UserEntity();
        if (json.getInt("status") == 1){
            userEntity = (UserEntity)JSONObject.toBean(json.getJSONObject("user"),UserEntity.class);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, userEntity.getLoginPassword(), getName());
        return info;
    }
}
