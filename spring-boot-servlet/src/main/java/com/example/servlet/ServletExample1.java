package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletExample1", urlPatterns = "/servletExample1", initParams = {
		@WebInitParam(name = "name", value = "java"), @WebInitParam(name = "age", value = "18") })
public class ServletExample1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletExample1 通过注解 @WebServlet 使用servlet");

		String name = getServletConfig().getInitParameter("name");
		String age = getServletConfig().getInitParameter("age");

		resp.getOutputStream().println("name is " + name);
		resp.getOutputStream().println("age is " + age);
	}
}
