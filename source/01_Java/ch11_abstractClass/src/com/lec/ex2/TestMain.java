package com.lec.ex2;

public class TestMain {
	public static void main(String[] args) {
		SuperClass Obj = new ChildClass(); // SuperClass�� Ÿ�����θ� ����. ��ü ������ �Ұ���
		Obj.method1();
		Obj.method2();
		Obj.method3();
		SuperClass sObj = new SuperClass() {
			
			@Override
			public void method1() {
				System.out.println("�͸�Ŭ������ method1");
				
			}
		};
		sObj.method1(); sObj.method2(); sObj.method3();
	}
	
}
