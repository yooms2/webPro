package com.lec.ex2_thread;
// �ȳ��ϼ��� 10�� �ݺ�
public class TargetEx01 extends Thread {
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println(Thread.currentThread().getName() + "�ȳ��ϼ��� - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
