package com.lec.conditionQuiz;
public class Quiz4 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		int you = (int)(Math.random()*3);
		if(you == com) {
			System.out.println("��" + you + "\t(�����)" + "\t��" + com);
		}else if(you > com) {
			System.out.println("��" + you + "\t(�̰���)" + "\t��" + com);	
		}else if(you < com) {
			System.out.println("��" + you + "\t(�����)" + "\t��" + com);
		}
	}
}
