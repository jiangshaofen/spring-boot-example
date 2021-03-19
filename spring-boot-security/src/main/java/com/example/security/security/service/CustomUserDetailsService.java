package com.example.security.security.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.security.domain.SecurityUser;
import com.example.security.service.SecurityUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
 

/**
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 * 
 * @author jiang
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
	protected static Logger logger = LoggerFactory.getLogger("CustomUserDetailsService");

	@Autowired
	private SecurityUserService securityUserService;
	private GrantedAuthority DEFAULT_ROLE = new SimpleGrantedAuthority("ROLE_USER");

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		if (!StringUtils.hasLength(username)) {
			throw new BadCredentialsException("用户名不能为空");
		}

		UserDetails userdetails = null;

		try {
			// 1.根据用户名从数据库查询用户信息，根据自己的业务规则去写
			SecurityUser serurityUser = securityUserService.selectByUserName(username);
			if (serurityUser == null) {
				throw new BadCredentialsException("用户名不存在");
			}

			// 2. 设置角色
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			String dbRole = serurityUser.getRole();
			if (!StringUtils.hasLength(dbRole)) {
				grantedAuthorities.add(DEFAULT_ROLE);
			} else {
				String[] roles = dbRole.split(",");
				for (String role : roles) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
					grantedAuthorities.add(grantedAuthority);
				}
			}

			userdetails= new org.springframework.security.core.userdetails.User(username, serurityUser.getPassword(), 
					true, // 激活状态，true:yes;false:no
					true, // 账号过期状态，true:no;false;yes
					true, // 证书过期状态，true:no;false;yes
					true, // 账号锁定状态，true:no;false;yes
					// AuthorityUtils.createAuthorityList("ROLE_USER")
					grantedAuthorities);
		} catch (Exception e) {
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return userdetails;
	}
}
