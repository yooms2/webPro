package com.lec.ex1_runnable;

public class TargetEx01 implements Runnable {
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			System.out.println("�ȳ��ϼ���~ " + i + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	} // run
}
