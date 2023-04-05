package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExamPrintImpl implements ExamPrint {
	private Exam exam;
	public void print() {
		System.out.println("�̸� : " + exam.getName());
		System.out.println("���� : " + exam.getTotal());
		System.out.printf("��� : %5.1f\n", + exam.getAvg());
	}

}
