package org.icec.web.shiro.realm;


import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFormRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService userRepository;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token != null && token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = (String)upToken.getPrincipal();
        if(username==null) return null;
        SysUser user = userRepository.findByUserId(upToken.getUsername());
        if (user != null) {
            SimpleAccount account = new SimpleAccount(user, user.getCredentials(), getName());
         // TODO 根据id查询用户的角色 user.getUserId  roleservice.queryRole(id);
            Set<String> roles = new HashSet<>();
            account.addRole(roles);  
            return account;
        }

        return null;
    }
    
        @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        	SysUser user=(SysUser)  principals.getPrimaryPrincipal();
        	// TODO 根据id查询用户的角色 user.getUserId  roleservice.queryRole(id);
        	
        	 Set<String> roles = new HashSet<>();
        	return new SimpleAuthorizationInfo(roles);
    }
}
