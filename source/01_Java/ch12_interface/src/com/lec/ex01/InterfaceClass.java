package com.lec.ex01;
// CONSTATNT_NUM, CONSTANT_STRIING, method1(), method2()
public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {

	@Override
	public String method2() {
		System.out.println("���� ������ implements�� Ŭ�������� �� - method2");
		return null;
	}

	@Override
	public void method1() {
		System.out.println("���� ������ implements�� Ŭ�������� �� - method1");
	}
	
}
