package com.lec.ex;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num ;
		do {
			System.out.println("±¸±¸´Ü");
			num = scanner.nextInt() ;
		}while(2>num || num>9) ;
		fa(num) ;
	}
	private static void fa(int s) {
		for(int i=1 ; i<=9 ; i++) {
//			System.out.printf("%d*1,%d*2,%d*3,%d*4,%d*5,%d*6,%d*7,%d*8,%d*9\n", s, s, s, s, s, s, s, s, s, s);
			System.out.println(s + "*" + i + "=" + s*i);
		}
	}
}
