package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // 생성자 함수 1개 실행
		// A aObj = new A(); 둘 다 가능
		S aObj = new A(); // 생성자 함수 2개 실행(부모단+자식단)
		// B aObj = new B(); 둘 다 가능
		S bObj = new B(); // 생성자 함수 2개 실행(부모단+자식단)
		// C aObj = new C(); 둘 다 가능
		S cObj = new C(); // 생성자 함수 2개 실행(부모단+자식단)
//		S[] arr = {new S(), new A(), new B(), new C()};
		S[] arr = {sObj, aObj, bObj, cObj};
		for(S a : arr) {
			System.out.println("s = " + a.s);
		}
	}
}
