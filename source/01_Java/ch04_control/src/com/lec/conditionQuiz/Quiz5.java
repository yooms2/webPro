package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������� �Է��ϼ��� :");
		int mon = scanner.nextInt();
		if(mon>=1 && mon<=3) {
			System.out.println("��");
		}else if(mon>=4 && mon<=6) {
			System.out.println("����");
		}else if(mon>=7 && mon<=9) {
			System.out.println("����");
		}else if(mon>=10 && mon<=12) {
			System.out.println("�ܿ�");
		}else {
			System.out.println("��ȿ���� �ʴ� ���� �Դϴ�");
		}
		scanner.close();
	}

}
