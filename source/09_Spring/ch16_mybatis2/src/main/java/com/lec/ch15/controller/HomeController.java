package com.lec.ch15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("msg", "Hello, Mybatis!");
		return "home";
	}
}
