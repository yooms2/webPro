package com.lec.quiz;

import java.util.Scanner;

// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���_");
		int x = scanner.nextInt();
				
		String result = (x >= 65)? "��ο��" : "�Ϲ�" ;
		System.out.println("(65���̻� : ��ο��, 65�� �̸� : �Ϲ�)\n " + result);
		scanner.close();
	}
}