package com.lec.ch06.ex2;

import lombok.Data;

@Data
public class Student2 {
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
