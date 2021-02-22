package com.example.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletExample2Config {

	@Autowired
	private ServletExample2 servletExample2;

	@Bean
	public ServletRegistrationBean<ServletExample2> getServletRegistrationBean() {
		ServletRegistrationBean<ServletExample2> servletRegistrationBean = new ServletRegistrationBean<>();
		servletRegistrationBean.setServlet(servletExample2);
		servletRegistrationBean.addUrlMappings("/servletExample2");
		servletRegistrationBean.addInitParameter("name", "C#");
		servletRegistrationBean.addInitParameter("age", "22");
		return servletRegistrationBean;
	}
}
