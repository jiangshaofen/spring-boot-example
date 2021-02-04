package com.example.starter.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.starter.ExampleService;

@RestController
public class HelloController {

	@Autowired
    private ExampleService exampleService;

	//http://localhost:8081/springboot/hello?word=中国
    @GetMapping("/hello")
    public String input(String word){
        return "调用starter服务反馈的结果(在输入关键词前后增加指定字符)："+exampleService.wrap(word);
    }
}
