package com.lec.ex10_final;
// speed, running(), stop(final)--override�Ұ�
public final class Rabbit extends Animal {// Rabbit ��� ����
	@Override
	public void running() {
		speed += 30;
		System.out.println("�䳢�� ���� ���� �پ��. ����ӵ� : " + speed);
	}
}
