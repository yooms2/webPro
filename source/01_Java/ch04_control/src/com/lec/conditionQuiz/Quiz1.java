package com.lec.conditionQuiz;

import java.util.Scanner;
// int ~2147483647
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���밪�� �Է��ϼ��� :");
		int a = scan.nextInt();
		if(a > 0) {
			System.out.println("a");
		}else if(a < 0 ) {
			System.out.println("-a");
		}else if(a == 0) {
			System.out.println("0");
		}else {
			System.out.println("��ȿ���� �ʴ� ���Դϴ�");
		}
		scan.close();
	}

}
