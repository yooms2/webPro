package com.lec.ex06_toy;

public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println("������Դϴ�");
		canMissile();
		canLight();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canLight() {
		System.out.println("�Һ��ݻ� �� �� �ֽ��ϴ�");
	}
	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�");
	}
}
