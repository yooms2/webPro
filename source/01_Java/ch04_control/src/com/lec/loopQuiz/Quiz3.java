package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¸î ´Ü : ");
		int dan = scanner.nextInt();
		for(int i=1 ; i<10 ; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
		scanner.close();
	}
}
