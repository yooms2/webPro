package com.lec.ex06_toy;

public class MazingerToy implements IMissile, IMoveArmLeg {
	public MazingerToy() {
		System.out.println("��¡���Դϴ�");
		canMoveArmLeg();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�");
	}
	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�");
	}
}
