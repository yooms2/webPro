package com.lec.ex2_thread;

public class Ex01_ThreadExTestMain {
	public static void main(String[] args) {
		// "�� A"��� �̸��� ������ ���� - t1.run() ���ÿ� ������ ������
		Thread t1 = new ThreadEx();
		t1.setName("��A");
		// "~B"��� �̸��� ������ ���� - t2.run() ���ÿ� ������ ������
		Thread t2 = new ThreadEx("B");
		t1.start();
		t2.start();
		System.out.println("main �Լ� ������� : " + Thread.currentThread().getName());
		System.out.println("main �Լ� ��");
	}
}
