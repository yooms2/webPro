package com.lec.ex1_square;

public class SquareMain {
	// ������, ������, �޼ҵ�
	public static void main(String[] args) {
		Square s1 = new Square();
		System.out.println("s1�� �Ѻ��� " + s1.getSide());
		s1.setSide(2);
		System.out.println("������ s1�� ���̴� " + s1.area());
		Square s2 = new Square(10);
		System.out.println("s2�� �Ѻ��� ���̴� " + s2.getSide());
		System.out.println("s2�� ���̴� " + s2.area());
	}
}
