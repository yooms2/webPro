package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, computer;
		do {
			System.out.println("���������� : (����=0), (����=1), (��=2)");
			you = scanner.nextInt();
			computer = (int)(Math.random()*3);
			
			if(you == computer) {
				System.out.println(you + "(���)" + computer);
			}else if(you > computer) {
				System.out.println(you + "(�̱�)" + computer);
			}else if(you < computer) {
				System.out.println(you + "(��)" + computer);
			}
		}while(you >= computer);
		scanner.close();
		System.out.println("�������� �����ϼ���~");
		}
	}