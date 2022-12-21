package com.lec.ex5_synchronized;

public class TargetEx implements Runnable {
	private int num = 0;
	@Override
	public void run() {
		for (int i=0 ; i<10 ; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
	private synchronized void out() {
		if (Thread.currentThread().getName().equals("A")) {
			System.out.println("~ ~ ~ A ������ ������ num ���� ~ ~ ~");
			num ++;
		}
		System.out.println(Thread.currentThread().getName() + "�� num = " + num);
	}
}
