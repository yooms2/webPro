package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, computer;
		do {
			System.out.println("가위바위보 : (가위=0), (바위=1), (보=2)");
			you = scanner.nextInt();
			computer = (int)(Math.random()*3);
			
			if(you == computer) {
				System.out.println(you + "(비김)" + computer);
			}else if(you > computer) {
				System.out.println(you + "(이김)" + computer);
			}else if(you < computer) {
				System.out.println(you + "(짐)" + computer);
			}
		}while(you >= computer);
		scanner.close();
		System.out.println("다음번에 도전하세요~");
		}
	}