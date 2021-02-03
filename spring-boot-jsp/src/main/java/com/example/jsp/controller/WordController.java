package com.example.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordController {
	@RequestMapping("/word")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "nanjing") String name) {
		model.addAttribute("name", name);
		return "word";
	}
}
