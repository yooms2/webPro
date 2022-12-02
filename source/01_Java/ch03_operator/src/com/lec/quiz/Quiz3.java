package com.lec.quiz;

import java.util.Scanner;

// 두수를 입력받아 두 수가 같은지 결과를 O나 X로 출력. 
// 첫번째 수가 더 큰지 결과를 O나 X로 출력한다.

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째수를 입력하세요 ? ");
		int i = scanner.nextInt();
		System.out.print("두번째수를 입력하세요 ? ");
		int j = scanner.nextInt();
		
		String result = (i == j)? "O" : "X";
		System.out.println("두수가 같은지 여부 : " +result);
		
		result = (i > j)? "O" : "X";
		System.out.println("첫번째 수가 더 큰지 여부 : " + result);
		scanner.close();
	}

}


