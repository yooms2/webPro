package com.lec.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	@RequestMapping(value="/")
	public String input(Model model) {
		return "student/input";
	}
}
