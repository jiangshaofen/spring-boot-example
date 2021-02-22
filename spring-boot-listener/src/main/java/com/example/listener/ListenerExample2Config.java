package com.example.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

public class ListenerExample2Config {

	@Autowired
	private ListenerExample2 listenerExample2;

	@Bean
	public ServletListenerRegistrationBean<ListenerExample2> getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean<ListenerExample2> listenerRegistrationBean = new ServletListenerRegistrationBean<>();
		listenerRegistrationBean.setListener(listenerExample2);

		return listenerRegistrationBean;
	}
}
