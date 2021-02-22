package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

@Component
public class ListenerExample2 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("ListenerExample2 通过注解 使用 Listener:Servlet容器初始化...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("ListenerExample2 通过注解 使用 Listener:Servlet容器被销毁了");

	}
}
