package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.security.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//        	   http
//                .authorizeRequests()
//                .antMatchers("/product/**").hasRole("USER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();
		
		http.csrf().disable();
		
		http.httpBasic()
		.and()
		.formLogin().loginPage("/auth/login").loginProcessingUrl("/login").defaultSuccessUrl("/main/common")
		.failureUrl("/auth/login?error=true")
		.and()
		.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/auth/login")
		.and().authorizeRequests()
				.antMatchers("/fonts/**", "/js/**").permitAll() // 默认不拦截静态资源的url
				.antMatchers("/auth/login").permitAll()
				.antMatchers("/auth/logout").permitAll()
				.antMatchers("/main/common").hasRole("ADMIN")
				.antMatchers("/admin/admin").hasRole("ADMIN")
				.antMatchers("/admin/denied").hasRole("ADMIN")
				.antMatchers("/admin/user").hasRole("USER")
				.anyRequest().authenticated();
				}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// db user test
				auth.userDetailsService(customUserDetailsService)// 设置自定义的userDetailsService
						.passwordEncoder(passwordEncoder());
		// in memory test
//        auth.inMemoryAuthentication()
//            .withUser("admin").password("{noop}adminpass").roles("ADMIN", "USER") // 管理员，同时具有 ADMIN,USER权限，可以访问所有资源
//            .and()
//            .withUser("spring").password("{noop}123456").roles("USER"); // 普通用户，只能访问有限的资源。
	}
}
