package com.example.filter;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterExample3Config {

	@Bean
	public Filter filterExample3() {
		return new FilterExample3();
	}
}
