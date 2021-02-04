package com.example.starter;

//几个和Starter相关的注解
//@ConditionalOnClass，当classpath下发现该类的情况下进行自动配置。
//@ConditionalOnMissingBean，当Spring Context中不存在该Bean时。
//@ConditionalOnProperty(prefix = "example.service",value = "enabled",havingValue = "true")，当配置文件中example.service.enabled=true时。
//
//最后一步，在resources/META-INF/下创建spring.factories文件

//总结下Starter的工作原理
//
//1.Spring Boot在启动时扫描项目所依赖的JAR包，寻找包含spring.factories文件的JAR包
//2.根据spring.factories配置加载AutoConfigure类
//3.根据 @Conditional注解的条件，进行自动配置并将Bean注入Spring Context
