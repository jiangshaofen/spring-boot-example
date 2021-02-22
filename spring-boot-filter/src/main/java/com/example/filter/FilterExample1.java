package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 通过注解，配合自动扫描与当前类的同包以及子包 @ServletComponentScan
 * 
 * @author jiang
 *
 */
@WebFilter(filterName = "filterExample1", urlPatterns = "/filterExample1")
public class FilterExample1 implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterExample1 通过注解 @WebFilter，配合自动扫描与当前类的同包以及子包 (@ServletComponentScan)使用 filter");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}