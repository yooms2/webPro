package com.lec.ch06.ex1;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	public void getStudentInfo() { // ȣ��� �ٽɱ��(joinPoint=����Ͻ�����, Ÿ�ٸ޼ҵ�)
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("�г� : " + gradeNum);
		System.out.println("�� : " + classNum);
	}
}
