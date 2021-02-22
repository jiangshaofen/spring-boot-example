package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class ServletExample2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletExample2 通过注解 @Component 及 ServletRegistrationBean 注册使用servlet");
		
		String name = getServletConfig().getInitParameter("name");
		String age = getServletConfig().getInitParameter("age");

		resp.getOutputStream().println("name is " + name);
		resp.getOutputStream().println("age is " + age);
	}
}
