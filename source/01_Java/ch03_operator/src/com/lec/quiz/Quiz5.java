package com.lec.quiz;

import java.util.Scanner;

// ����, ����, ���� ������ ����ڿ��� �Է¹޾�, �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� ���� ? ");
		int kor = scanner.nextInt();
		System.out.print("���� ���� ? ");
		int eng = scanner.nextInt();
		System.out.print("���� ���� ? ");
		int mat = scanner.nextInt();
		
		int sum = kor + eng + mat;
		double avg = sum/3.;
		System.out.printf("���� = %d, ���� = %d, ���� = %d\n", kor, eng, mat);
		System.out.printf("���� = %d, ��� = %.2f\n", sum, avg);
		scanner.close();
	}

}