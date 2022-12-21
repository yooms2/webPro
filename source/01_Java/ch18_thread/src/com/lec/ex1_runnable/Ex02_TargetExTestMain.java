package com.lec.ex1_runnable;

public class Ex02_TargetExTestMain {
	public static void main(String[] args) {
		Runnable target01 = new TargetEx01(); // �ȳ��ϼ��� 10��
		Runnable target02 = new TargetEx02(); // �ݰ����ϴ� 20��
		// A��� �̸��� ������ ���� - �ȳ��ϼ��� 10�� ������ ������
		Thread threadA = new Thread(target01);
		threadA.setName("A");
		
		// ������ ����(�̸��� �ڵ�����) - �ݰ����ϴ� 20�� ������ ������
		Thread threadB = new Thread(target02);
		threadA.start();
		threadB.start();
		for(int i=0 ; i<10 ; i++) {
			System.out.println("���� " + Thread.currentThread().getName() + "�� i = " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}
