package com.lec.ex4_object;

public class Person {
	private long juminNo; // 981212 2512541
	public Person() {}
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "주민번호는" + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// this의 주민번호와 obj의 주민번호가 같은지 다른지 여부
//		return (this == obj); // p1.equals(p2) : p1이 this. p2가 obj
		if(obj!=null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
	}
}