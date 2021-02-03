package com.example.thymeleaf.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "shanghai") String name) {
		model.addAttribute("name", name);

		User user = new User();
		user.setUsername("jiang");
		user.setPassword("hijiang");
		user.setHobbies(Arrays.asList(new String[] { "code", "book", "football" }));
		Map<String, String> maps = new HashMap<>();
		maps.put("1", "o");
		maps.put("2", "g");
		maps.put("3", "a");
		maps.put("4", "j");
		user.setSecrets(maps);
		model.addAttribute("user", user);
		
		return "hello";
	}
}
