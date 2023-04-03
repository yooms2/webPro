package com.lec.ch02.ex3_student;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentPrint {
	private Student student;
	public void print() {
		if(student!=null) {
			System.out.println("--------------------");
			System.out.println("�̸� : "+ student.getName());
			System.out.println("���� : "+ student.getAge());
			System.out.println("�г� : "+ student.getGradeNum());
			System.out.println("�� : "+ student.getClassNum());
			System.out.println("--------------------");
		} else {
			System.out.println("�����ϴ� Student�� ��ü�� �����ϴ�");
		}
	}
}
