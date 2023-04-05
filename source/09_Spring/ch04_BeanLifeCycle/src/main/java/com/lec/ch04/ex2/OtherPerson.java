package com.lec.ch04.ex2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;

@Data
public class OtherPerson {
	private String name;
	private int age;
	@PostConstruct
	public void initMethod() {
		System.out.println("OtherPerson�� �� ��ü �������ڸ��� �ڵ� ȣ�� : initMethod()");
	}
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("OtherPerson�� �� ��ü �Ҹ� �� �ڵ� ȣ�� : preDestroyMethod()");
	}
}
