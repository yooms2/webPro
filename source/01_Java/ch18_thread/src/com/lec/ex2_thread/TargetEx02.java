package com.lec.ex2_thread;
// �ݰ����ϴ�. 20�� �ݺ�
public class TargetEx02 extends Thread {
	@Override
	public void run() {
		for(int i=0 ; i<20 ; i++) {
			System.out.println(Thread.currentThread().getName() + " �ݰ����ϴ�. " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
