package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j=1; // ����ڿ��� �Է¹��� ���� ����
		System.out.print("ù��° ������?");
		do {
			try {
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("���� ���ڸ� ���� ������");
				scanner.nextLine(); // ���۸� ����� ����
			}
		}while(true);
		System.out.print("�ι�° ������?");
		try {
			j = scanner.nextInt();
			System.out.println("i / j = " + (i/j)); // ���ܰ� �߻��� ���� �ִ� �κ�
		}catch(ArithmeticException e) { // ���ܹ߻��� ���� �κ�
			System.out.println(e.getMessage()); // ���ܸ޼��� ���
//			e.printStackTrace();
		}catch(InputMismatchException e) {
			System.out.println("���ܸ޼��� : " + e.getMessage());
			System.out.println("j�� �߸� �Է��ϼż� 1�� ó���մϴ�");
		}
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
