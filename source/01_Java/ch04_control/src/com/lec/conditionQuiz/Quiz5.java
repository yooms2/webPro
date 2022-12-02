package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇월인지 입력하세요 :");
		int mon = scanner.nextInt();
		if(mon>=1 && mon<=3) {
			System.out.println("봄");
		}else if(mon>=4 && mon<=6) {
			System.out.println("여름");
		}else if(mon>=7 && mon<=9) {
			System.out.println("가을");
		}else if(mon>=10 && mon<=12) {
			System.out.println("겨울");
		}else {
			System.out.println("유효하지 않는 계절 입니다");
		}
		scanner.close();
	}

}
