package com.lec.ex01;

public class TestMain {
	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1();
		InterfaceClass obj = new InterfaceClass();
		obj.method1();
		System.out.println(obj.method2());
		InterfaceEx1 obj1 = new InterfaceClass();
		obj1.method1();
		// obj1.method2();
		InterfaceEx2 obj2 = new InterfaceClass();
		// obj2.method1();
		obj2.method2();
		System.out.println("��� CONSTANT_NUM : " + InterfaceEx1.CONSTATNT_NUM);
		System.out.println("��� CONSTANT_NUM : " + InterfaceClass.CONSTATNT_NUM);
		System.out.println("��� CONSTANT_NUM : " + obj.CONSTATNT_NUM); // static�� class ���� ��õ
		System.out.println("��� CONSTANT_STRING : " + InterfaceEx2.CONSTANT_STRIING);
		System.out.println("��� CONSTANT_STRING : " + obj.CONSTANT_STRIING);
	}
}
