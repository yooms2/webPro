package com.lec.ch03.method2;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.ch03.Student;
import com.lec.ch03.StudentInfo;

@Configuration
public class Method2_ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("ÅÂ±Çµµ"); hobbies.add("¸¶¶óÅæ");
		Student student = new Student("È«±æµ¿", 15, hobbies);
		student.setHeight(170.5);
		student.setWeight(65);
		return student;
	}
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudent(student1());
		return studentInfo;
	}
}
