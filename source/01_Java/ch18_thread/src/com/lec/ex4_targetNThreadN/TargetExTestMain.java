package com.lec.ex4_targetNThreadN;
// target��ü�� N��, ������� N�� = ������ �ϳ��� target��ü�� ����
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable targetA = new TargetEx(); // run()�Լ��� A�� num����, A�� �ƴϸ� num=0
		Runnable targetB = new TargetEx();
		Thread threadA = new Thread(targetA, "A");
		Thread threadB = new Thread(targetB, "B");
		threadA.start();
		threadB.start();
		System.out.println("main �Լ� ��");
	}
}
