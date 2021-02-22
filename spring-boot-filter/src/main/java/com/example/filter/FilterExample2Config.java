package com.example.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterExample2Config {

	@Autowired
	private FilterExample2 filterExample2;

	@Bean
	public FilterRegistrationBean<FilterExample2> getFilterRegistrationBean() {
		FilterRegistrationBean<FilterExample2> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(filterExample2);
		filterRegistrationBean.addUrlPatterns("/filterExample2");
		filterRegistrationBean.setName("filterExample2");
		filterRegistrationBean.setOrder(1); // 值越小，Filter越靠前。
		return filterRegistrationBean;
	}

	// 如果有多个Filter，再写一个public FilterRegistrationBean registerOtherFilter(){...}即可。
}
