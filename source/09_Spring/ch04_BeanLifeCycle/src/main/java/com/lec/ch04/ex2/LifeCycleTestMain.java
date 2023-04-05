package com.lec.ch04.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LifeCycleTestMain {
	public static void main(String[] args) {
		String location = "classpath:META-INF/ex2/applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location); // 牧抛捞呈 积己 -> 颇教 -> 按眉积己
		// IOC 牧抛捞呈 积己
		System.out.println("1. 牧抛捞呈 积己");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// 颇教
		System.out.println("2. 颇教");
		ctx.load(location);
		// 按眉 积己
		System.out.println("3. 按眉积己");
		ctx.refresh();
		// 后 荤侩
		System.out.println("4. 后 林涝罐酒 荤侩");
		System.out.println("==============================");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		OtherPerson other = ctx.getBean("otherPerson", OtherPerson.class);
		System.out.println(other);
		System.out.println("==============================");
		System.out.println("5. IOC 牧抛捞呈 家戈");
		ctx.close();
	}
}
