package com.lec.ex3_target1ThreadN;
// target��ü�� 1��, ������� N�� = ������ �ϳ��� target��ü�� ����
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable target = new TargetEx(); // run()�Լ��� A�� num����, A�� �ƴϸ� num=0
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		System.out.println("main �Լ� ��");
	}
}
