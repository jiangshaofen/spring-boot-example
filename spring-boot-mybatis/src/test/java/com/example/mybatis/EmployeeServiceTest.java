package com.example.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.mybatis.domain.Employee;
import com.example.mybatis.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration

public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void getEmployeeTest()
	{
		Employee para = new Employee();
		para.setId(1);
		Employee employee = employeeService.getEmployee(para);
		
		System.err.println("name:"+employee.getLastname());
	}
}
