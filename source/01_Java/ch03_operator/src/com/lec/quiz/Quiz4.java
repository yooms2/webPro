package com.lec.quiz;

import java.util.Scanner;

// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ��� ? ");
		int x = scanner.nextInt();
		int i = 65;
				
		String result = (x >= i)? "��ο��" : "�Ϲ�" ;
		System.out.println("���̰� 65���̻����� Ȯ�� : " + result);
		scanner.close();
	}
}