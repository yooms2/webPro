package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor // 매개변수 없는 생성자
@AllArgsConstructor // 매개변수 있는 생성자 만든 것과 같다(순서 확인)
public class ExamImpl2 implements Exam {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	public int getTotal() {
		return kor+eng+mat;
	}
	public double getAvg() {
		return getTotal()/3.0;
	}
}