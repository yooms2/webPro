package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true); // ���α׷� ����� timer�� �޸� �������� X
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); // 2�� �� �ѹ� task.run() ����
		timer.schedule(task2, 1000,500); // 1�� �� ���� 0.5�ʸ��� task2.run() ����
		Thread.sleep(11000);
		System.out.println("��");
	}
}
