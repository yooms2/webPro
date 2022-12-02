package com.lec.quiz;

import java.util.Scanner;

// 나이를 입력받아 입력받은 나이가 65세 이상일 때, “경로우대” 출력, 아니면 “일반”출력
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요 ? ");
		int x = scanner.nextInt();
		int i = 65;
				
		String result = (x >= i)? "경로우대" : "일반" ;
		System.out.println("나이가 65세이상인지 확인 : " + result);
		scanner.close();
	}
}