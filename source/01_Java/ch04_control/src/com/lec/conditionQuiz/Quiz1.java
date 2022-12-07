package com.lec.conditionQuiz;

import java.util.Scanner;
// int ~2147483647
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("절대값을 입력하세요 :");
		int a = scan.nextInt();
		if(a > 0) {
			System.out.println("a");
		}else if(a < 0 ) {
			System.out.println("-a");
		}else if(a == 0) {
			System.out.println("0");
		}else {
			System.out.println("유효하지 않는 값입니다");
		}
		scan.close();
	}

}
