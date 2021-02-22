package com.example.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterExample4Config {

	@Bean
	public Filter filterExample4() {
		return new FilterExample4();
	}

	@Bean
	public DelegatingFilterProxyRegistrationBean delegatingFilterProxyRegistrationBean() {
		DelegatingFilterProxyRegistrationBean registrationBean = new DelegatingFilterProxyRegistrationBean("filterExample4");
		registrationBean.addUrlPatterns("/filterExample4"); // 设置拦截pattern
		registrationBean.setOrder(3);// 设置顺序
		// ......
		return registrationBean;
	}
}
