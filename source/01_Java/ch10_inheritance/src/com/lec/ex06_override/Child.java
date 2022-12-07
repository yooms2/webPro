package com.lec.ex06_override;
// method1(), method2() ���� ����
public class Child extends Parent {
	public Child() { // overloading = �Լ� �ߺ�����
		System.out.println("�Ű����� ���� Child ������");
	}
	public Child(int i) {
		System.out.println("�Ű����� �ִ� Child ������");
	}
	@Override
	public void method1() { // override = �Լ��� ������
		System.out.println("Child�� method1()");
	}
	public void method3() {
		System.out.println("Child�� method3()");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
