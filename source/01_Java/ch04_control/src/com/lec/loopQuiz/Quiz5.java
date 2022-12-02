package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위바위보 : (가위=0), (바위=1), (보=2)");
		int you = scanner.nextInt();
		
		int computer = (int)(Math.random()*3);
		if(you == computer) {
			System.out.println(you + "(비김)" + computer);
		}else if(you > computer) {
			System.out.println(you + "(이김)" + computer);
		}else if(you < computer) {
			System.out.println(you + "(짐)" + computer);
		}
	} //main
} //class