package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������� : (����=0), (����=1), (��=2)");
		int you = scanner.nextInt();
		
		int computer = (int)(Math.random()*3);
		if(you == computer) {
			System.out.println(you + "(���)" + computer);
		}else if(you > computer) {
			System.out.println(you + "(�̱�)" + computer);
		}else if(you < computer) {
			System.out.println(you + "(��)" + computer);
		}
	} //main
} //class