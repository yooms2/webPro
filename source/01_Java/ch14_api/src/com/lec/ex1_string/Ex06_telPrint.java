package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;
		do {
			System.out.println("��ȭ��ȣ:(x:����)");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("��ȭ��ȣ : " + tel);
			System.out.print("¦����° ���ڿ� : ");
			for(int i=0 ; i<tel.length() ; i++) {
				if(i%2 == 0)
					System.out.print(tel.charAt(i) + " ");
			}
			System.out.println();
			System.out.print("���ڸ� �Ųٷ� : ");
			for(int i=tel.length()-1 ; i>=0 ; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			System.out.println("��ȭ��ȣ �Ǿ��ڸ��� : " + tel.substring(0, tel.indexOf("-"))); // 0��°���� ù(-) �ձ���
			System.out.println("��ȭ��ȣ ���ڸ��� : " + tel.substring(tel.lastIndexOf("-")+1)); // ������(-)����
		}while(true);
		sc.close();
		System.out.println("BYE");
	}
}
