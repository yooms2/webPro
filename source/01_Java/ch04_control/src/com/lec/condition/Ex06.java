package com.lec.condition;

import java.util.Scanner;

// �Է¹��� ���� Ȧ������ ¦������ ���
public class Ex06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		int num = scanner.nextInt();
		switch (num%2) {
		case 0:
			System.out.println("¦���Դϴ�");
			break;
		default:
			System.out.println("Ȧ���Դϴ�");
			break;
		}
		scanner.close();
	}
}
