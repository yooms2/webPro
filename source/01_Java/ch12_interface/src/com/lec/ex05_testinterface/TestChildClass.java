package com.lec.ex05_testinterface;
// i1, i2, i3, i11, m1(), m2(), m3(), m11()
public class TestChildClass extends TestClass implements I11 {

	@Override
	public void m11() {
		System.out.println("��� i11= " + i11);
	}

}
