package com.lec.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻��� �ζ� ������ ���߱�
public class Ex11doWhile_lotto1 {
	public static void main(String[] args) {
		int lotto, su; // ��ǻ�� �ζǹ�ȣ�� ����ڷ� ���� �Է¹��� ��
		int min = 1, max = 45;
		Scanner scanner = new Scanner(System.in);
		lotto = (int)(Math.random()*45+1); // �ζǹ�ȣ
		do {
			System.out.printf("�ζ� ��ȣ �Ѱ��� ���� ������(%d~%d) : ", min, max);
			su = scanner.nextInt();
			if(su<min || su>max) {
				System.out.println("�־��� ������ �����ϼ���");
			}else if(su>lotto) {
				max = su-1;
				//System.out.println(su + "���� ���� ���� �����ϼ���");
			}else if(su<lotto) {
				min = su+1;
				//System.out.println(su + "���� ū ���� �����ϼ���");
			}
		}while(su != lotto);
		System.out.println("�������� ���߼̽��ϴ�");
	}
}
