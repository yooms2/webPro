package com.lec.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.quiz.vo.Student;
@Controller
@RequestMapping("student")
public class StudentController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	@ModelAttribute("sum")
	public int sum(Student student) {
		return student.getKor()+student.getEng()+student.getMat();
	}
	@ModelAttribute("avg")
	public double avg(Student student) {
		return (student.getKor()+student.getEng()+student.getMat())/3.0;
	}
	@RequestMapping(value="join")
	public String join(Student student) {
		return "student/result";
	}
}
