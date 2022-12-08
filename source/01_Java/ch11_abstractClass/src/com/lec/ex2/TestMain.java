package com.lec.ex2;

public class TestMain {
	public static void main(String[] args) {
		SuperClass Obj = new ChildClass(); // SuperClass는 타입으로만 가능. 객체 생성은 불가능
		Obj.method1();
		Obj.method2();
		Obj.method3();
		SuperClass sObj = new SuperClass() {
			
			@Override
			public void method1() {
				System.out.println("익명클래스의 method1");
				
			}
		};
		sObj.method1(); sObj.method2(); sObj.method3();
	}
	
}
