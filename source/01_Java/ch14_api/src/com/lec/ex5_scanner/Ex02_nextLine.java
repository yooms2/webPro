package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ּҴ� : ");
		// scanner.nextLine(); ��������� ���� ó�������� �ʿ����� �ʴ�
		String address = scanner.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ� " + address);
		System.out.print("���� : ");
		int age = scanner.nextInt();
		System.out.println("���̴� " + age);
		System.out.print("�̸� : ");
		// ���� ���ۿ� "\n"�� �ִ� ����
		scanner.nextLine(); // ���� ����� ����
		String name = scanner.nextLine();
		System.out.println("�Է��Ͻ� �̸��� " + name);
		System.out.println("���α׷� ��");
	}
}
