package com.lec.ch06.ex2;

import lombok.Data;

@Data
public class Worker2 {
	private String name;
	private int age;
	private String job;
	public void getWorkerInfo() { // ȣ��� �ٽɱ��(joinPoint, ����Ͻ�����=Ÿ�ٸ޼ҵ�)
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("��å : " + job);
	}
}
