package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_ScannerObj {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("�̸��� ? ");
		String name = scMain.nextLine();
		System.out.println("�Է��� �̸��� " + name);
		// �޼ҵ� : ������ �Է¹޾� ���
		getNickName();
		System.out.print("���̴� ? ");
		int age = scMain.nextInt();
		System.out.println("�Է��� ���̴� " + age);
		scMain.close();
	}
	private static void getNickName() {
		Scanner scNick = new Scanner(System.in);
		System.out.print("������ ?");
		String nickName = scNick.next();
		System.out.println("�Է��� ������ " + nickName);
	}
}
