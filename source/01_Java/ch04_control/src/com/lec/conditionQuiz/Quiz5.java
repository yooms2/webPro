package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇월인지 입력하세요 :");
		int mon = scanner.nextInt();
		if(1<=mon && mon<=3) {
			System.out.println("봄");
		}else if(4<=mon && mon<=6) {
			System.out.println("여름");
		}else if(7<=mon && mon<=9) {
			System.out.println("가을");
		}else if(10<=mon && mon<=12) {
			System.out.println("겨울");
		}else {
			System.out.println("유효하지 않는 계절 입니다");
		}
		scanner.close();
	}

}
