package com.lec.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻��� �ζ� ������ ���߱�
public class Ex11doWhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su; // ��ǻ�� �ζǹ�ȣ�� ����ڷ� ���� �Է¹��� ��
		Scanner scanner = new Scanner(System.in);
		// 0 <= Math.random() < 1 : �Ǽ�
		// 0 <= Math.rando,()*45 < 45 : �Ǽ�
		// 1 <= Math.rando,()*45+1 < 46 : �Ǽ�
		// 1 <= (int)(Math.rando,()*45+1) < 46 : ����
		lotto = (int)(Math.random()*45+1); // �ζǹ�ȣ
		do {
			System.out.print("�ζ� ��ȣ �Ѱ��� ���� ������(1~45) : ");
			su = scanner.nextInt();
			if(su>lotto) {
				System.out.println(su + "���� ���� ���� �����ϼ���");
			}else if(su<lotto) {
				System.out.println(su + "���� ū ���� �����ϼ���");
			}
		}while(su != lotto);
		System.out.println("�������� ���߼̽��ϴ�");
	}
}
