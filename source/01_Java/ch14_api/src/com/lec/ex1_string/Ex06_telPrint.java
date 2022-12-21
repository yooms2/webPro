package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;
		do {
			System.out.println("전화번호:(x:종료)");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("전화번호 : " + tel);
			System.out.print("짝수번째 문자열 : ");
			for(int i=0 ; i<tel.length() ; i++) {
				if(i%2 == 0)
					System.out.print(tel.charAt(i) + " ");
			}
			System.out.println();
			System.out.print("문자를 거꾸로 : ");
			for(int i=tel.length()-1 ; i>=0 ; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			System.out.println("전화번호 맨앞자리는 : " + tel.substring(0, tel.indexOf("-"))); // 0번째부터 첫(-) 앞까지
			System.out.println("전화번호 뒷자리는 : " + tel.substring(tel.lastIndexOf("-")+1)); // 마지막(-)부터
		}while(true);
		sc.close();
		System.out.println("BYE");
	}
}
