package com.lec.ex06_toy;

public class PoohToy implements IMoveArmLeg {
	public PoohToy() {
		System.out.println("������ Ǫ�Դϴ�");
		canMoveArmLeg();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�");
	}
}
