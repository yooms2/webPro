package com.lec.ex4_object;

public class Person {
	private long juminNo; // 981212 2512541
	public Person() {}
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "�ֹι�ȣ��" + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// this�� �ֹι�ȣ�� obj�� �ֹι�ȣ�� ������ �ٸ��� ����
//		return (this == obj); // p1.equals(p2) : p1�� this. p2�� obj
		if(obj!=null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
	}
}