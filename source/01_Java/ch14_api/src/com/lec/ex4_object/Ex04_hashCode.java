package com.lec.ex4_object;

public class Ex04_hashCode {
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = new String("Hello");
		if(str1 == str2) {
			System.out.println("�ּҰ� ����(���� ���� ����)");
		}else {
			System.out.println("�ּҰ� �ٸ�(�ٸ� ���� ����)");
		}
		Card card = new Card('��', 2);
		System.out.println(card.hashCode());
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}
