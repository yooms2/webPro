package com.lec.condition;

import java.util.Scanner;

// �� ���� �Է¹޾� � ���� �󸶳� �� ū�� ����Ͻÿ�
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° ���� :");
		int num1 = scanner.nextInt();
		System.out.print("�ι�° ���� :");
		int num2 = scanner.nextInt();
		if(num1 > num2) {
			System.out.printf("ù��° ��(%d)�� %d��ŭ �� Ů�ϴ�", num1, (num1-num2));	
		}else if(num1 < num2) {
			System.out.printf("�ι�° ����(%d)�� %d��ŭ �� Ů�ϴ�", num2, (num2-num1));
		}else {
			System.out.println("���� ���� �Է��ϼ̽��ϴ�");
		} // if
		scanner.close();
	} // main
} // class
