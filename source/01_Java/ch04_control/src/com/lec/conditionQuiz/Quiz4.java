package com.lec.conditionQuiz;
public class Quiz4 {
	public static void main(String[] args) {
		int com = (int)(Math.random()*3);
		int you = (int)(Math.random()*3);
		if(you == com) {
			System.out.println("나" + you + "\t(비겼어요)" + "\t컴" + com);
		}else if(you > com) {
			System.out.println("나" + you + "\t(이겼어요)" + "\t컴" + com);	
		}else if(you < com) {
			System.out.println("나" + you + "\t(졌어요)" + "\t컴" + com);
		}
	}
}
