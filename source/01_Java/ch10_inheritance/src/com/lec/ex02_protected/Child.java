package com.lec.ex02_protected;
// private i, j / public setI(), getI(), setJ(), getJ() 다 들어온 것 
public class Child extends SuperIJ {
	private int total;
	public Child() {
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	public Child(int i, int j) { // 오후 수정
		System.out.println("매개변수 있는 Child 생성자 함수 - i, j 초기화");
		//setI(i); => private 일때
		this.i = i; // => protected 일때
		//setJ(j);
		this.j = j;
	}
	public void sum() {
		//total = getI() + getJ(); => private 일때
		total = i + j; // => protected 일때
		System.out.println("i = " + getI()+ ", j = " +getJ() + ", total = " + total);
	}
}
