package com.lec.ex;
// ���������� : ++(1����), --(1����)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; // n1�� 1 �����ϰ� n2�� �Ҵ�
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1++;     // n1���� n2�� �Ҵ��� �� 1����
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = --n1;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1--;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
	}
}
