package com.lec.ex1_runnable;

public class Ex01_TargetTestMain {
	public static void main(String[] args) {
		Target target = new Target();
		// Runnable target = new Target();
		// "��A"��� �̸��� �����带 ���� - target.run()�� ���ÿ� ������ ������
		Thread t1 = new Thread(target, "��A");
		// "~B"��� �̸��� �����带 ���� - target.run()�� ���ÿ� ������ ������
		Thread t2 = new Thread(target, "~B");
		t1.start();
		t2.start();
		System.out.println("main�Լ� ������� : " + Thread.currentThread().getName());
		System.out.println("main�Լ� ��");
	}
}
