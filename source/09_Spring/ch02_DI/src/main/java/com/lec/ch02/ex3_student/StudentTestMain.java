package com.lec.ch02.ex3_student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentTestMain {
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX3.xml";
		// ��Ʈ�� ���������� �Ľ��ؼ� �����̳� ���� - student1, student2, studentPrint ������Ʈ
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		// ������Ʈ�� �����´� (DI)
		StudentPrint sPrint = ctx.getBean("studentPrint", StudentPrint.class);
		sPrint.print();
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		if(sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint�� student�� student1�� ���� ��ü��");
		} else {
			System.out.println("sPrint�� student�� student1�� �ٸ� ��ü��");
		}
		sPrint.setStudent(student2);
		sPrint.print();
		if(sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint�� student�� student1�� ���� ��ü��");
		} else {
			System.out.println("sPrint�� student�� student1�� �ٸ� ��ü��");
		}
		ctx.close();
	}
}
