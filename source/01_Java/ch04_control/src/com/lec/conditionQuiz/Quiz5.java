package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������� �Է��ϼ��� :");
		int mon = scanner.nextInt();
		if(1<=mon && mon<=3) {
			System.out.println("��");
		}else if(4<=mon && mon<=6) {
			System.out.println("����");
		}else if(7<=mon && mon<=9) {
			System.out.println("����");
		}else if(10<=mon && mon<=12) {
			System.out.println("�ܿ�");
		}else {
			System.out.println("��ȿ���� �ʴ� ���� �Դϴ�");
		}
		scanner.close();
	}

}
