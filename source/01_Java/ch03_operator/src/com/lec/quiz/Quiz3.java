package com.lec.quiz;

import java.util.Scanner;

// �μ��� �Է¹޾� �� ���� ������ ����� O�� X�� ���. 
// ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��°���� �Է��ϼ��� ? ");
		int i = scanner.nextInt();
		System.out.print("�ι�°���� �Է��ϼ��� ? ");
		int j = scanner.nextInt();
		
		String result = (i == j)? "O" : "X";
		System.out.println("�μ��� ������ ���� : " +result);
		
		result = (i > j)? "O" : "X";
		System.out.println("ù��° ���� �� ū�� ���� : " + result);
		scanner.close();
	}

}


