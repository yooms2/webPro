package com.lec.quiz.vo;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	private double avg;
}
