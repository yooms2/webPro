package com.lec.ch04.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LifeCycleTestMain {
	public static void main(String[] args) {
		String location = "classpath:META-INF/ex2/applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location); // �����̳� ���� -> �Ľ� -> ��ü����
		// IOC �����̳� ����
		System.out.println("1. �����̳� ����");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// �Ľ�
		System.out.println("2. �Ľ�");
		ctx.load(location);
		// ��ü ����
		System.out.println("3. ��ü����");
		ctx.refresh();
		// �� ���
		System.out.println("4. �� ���Թ޾� ���");
		System.out.println("==============================");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		OtherPerson other = ctx.getBean("otherPerson", OtherPerson.class);
		System.out.println(other);
		System.out.println("==============================");
		System.out.println("5. IOC �����̳� �Ҹ�");
		ctx.close();
	}
}
