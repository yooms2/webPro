package com.lec.ex2_date;

public class QuizSawonMain {
	public static void main(String[] args) {
		QuizSawon[] sawons = {new QuizSawon("a01", "ȫ�浿", "COMPUTER"),
							  new QuizSawon("a02", "�ű浿", "DESIGN"),
							  new QuizSawon("b01", "���浿", "HUMANRESOURCES")};
		for(QuizSawon sawon : sawons) {
			System.out.println(sawon);
		}
	}
}