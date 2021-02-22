package com.example.filter;

//springboot 定义filter主要有以下几种方式
//
//1.注册使用FilterRegistrationBean（建议使用）
//2.直接注册为spring bean（不能自定义属性，选择性使用）
//3.注册使用DelegatingFilterProxyRegistrationBean,
//  在使用托管场景下使用，比如：想修改通过2方式注册的filter的属性，2方式注册的filter将会失效
//4.结合@ServletComponentScan使用注解@WebFilter注册（Servlet提供的注册方式，在spring boot工程里不建议使用）
//5.自定义注册（基本不用，不推荐）