package com.lec.ex1_square;
// �Ӽ�, ������, �޼ҵ�, [setter&getter]
// Square s = new Square();
// Square s1 = new Square(10); // s�� side�� 10���� �ʱ�ȭ�ϸ鼭 ��ü ����
public class Square {
	private int side;
	public Square() {} {// ����Ʈ ������ �Լ� : return type�� ���� Ŭ������� ���� �Լ�
		System.out.println("�Ű����� ���� �Լ� ȣ��");
	}
	public Square(int side) { // �Ű������� �ִ� ������ �Լ� �뵵 :
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ��");
	}
	public int area() {
		return side * side;
	}
	// setter : s1.setSide(5);
	public void setSide(int side) {
		this.side = side;
	}
	// getter : sysout(s1.getSide())
	public int getSide() { 
		return side;
	}
}








