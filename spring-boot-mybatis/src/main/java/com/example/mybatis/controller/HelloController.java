package com.example.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mybatis.domain.Employee;
import com.example.mybatis.service.EmployeeService;

@Controller
public class HelloController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/hello")
	public String hello(Model model) {
		Employee para = new Employee();
		para.setId(1);
		Employee employee = employeeService.getEmployee(para);
		model.addAttribute("name", employee.getLastname());
		return "hello";
	}
}
