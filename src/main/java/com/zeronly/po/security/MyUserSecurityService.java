package com.zeronly.po.security;

import com.zeronly.po.model.common.LoginUser;
import com.zeronly.po.model.common.User;
import com.zeronly.po.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 获得对应的UserDetails，保存与认证相关的信息
 */
@Service
public class MyUserSecurityService implements UserDetailsService{
	@Autowired
	private IUserService iUserService;
	/**
	 * 通过重写loadUserByUsername方法查询对应的用户
	 * UserDetails是Spring Security的一个核心接口
	 * UserDetails定义了可以获取用户名、密码、权限等与认证相关信息的方法
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//根据用户名（页面接收的用户名）查询当前用户
		Map<String, Object> userfound = new HashMap<String, Object>();
		userfound.put("username",  username);

		List<User> myUser = iUserService.listByMap(userfound);

		if(CollectionUtils.isEmpty(myUser) || myUser.size()>1) {
			throw new UsernameNotFoundException("用户名不存在或该用户存在异常");
		}

		User user = myUser.get(0);
		
		LoginUser loginUser = new LoginUser();
		loginUser.setUser(user);
		return loginUser;
	}
}
