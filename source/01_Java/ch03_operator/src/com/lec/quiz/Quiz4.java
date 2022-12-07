package com.lec.quiz;

import java.util.Scanner;

// 나이를 입력받아 입력받은 나이가 65세 이상일 때, “경로우대” 출력, 아니면 “일반”출력
public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요_");
		int x = scanner.nextInt();
				
		String result = (x >= 65)? "경로우대" : "일반" ;
		System.out.println("(65세이상 : 경로우대, 65세 미만 : 일반)\n " + result);
		scanner.close();
	}
}