package com.lec.conditionQuiz;
import java.util.Scanner;
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2) �� �ϳ��� �����ϼ��� :");
		int you = scanner.nextInt(); // 0, 1, 2
		if(you == 0) {
			System.out.println("����� ����");
		}else if(you == 1) {
			System.out.println("��ſ� ����");
		}else if(you == 2) {
			System.out.println("����� ��");
		}else {
			System.out.println("��ȿ���� �ʴ� ���Դϴ�");
		}
		scanner.close();
	}

}
