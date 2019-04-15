package com.tujietg.gradpro.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.tujietg.gradpro.pojo.User;

import javax.annotation.Resource;

/**
 * shiro的realm
 * 
 * Created by tujietg on Apr 15, 2019.
 */
public class CustomRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;

	/**
	 * 授权
	 *
	 * @param principals {@link PrincipalCollection}
	 * @return {@link AuthorizationInfo}
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermission(user.getPercode());
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 *
	 * @param token {@link AuthenticationToken}
	 * @return {@link AuthenticationInfo}
	 * @throws AuthenticationException AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		System.out.println(username);
		String password = userService.getPasswd(username);
		System.out.println(password);
		User user = userService.getUserEntity(username);
		System.out.println("111111");
		return new SimpleAuthenticationInfo(user, password, "customrealm");
	}
}
