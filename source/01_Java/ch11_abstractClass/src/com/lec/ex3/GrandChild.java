package com.lec.ex3;
//method1(추상), method2, method3, method4(일반)
public class GrandChild extends ChildAbstract{ // GrandChild만 객체 생성 가능

	@Override
	public void method1() {
		System.out.println("GrandChild의 method1");
	}
}
