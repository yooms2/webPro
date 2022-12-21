package com.lec.ex2_date;

public class QuizSawonMain {
	public static void main(String[] args) {
		QuizSawon[] sawons = {new QuizSawon("a01", "홍길동", "COMPUTER"),
							  new QuizSawon("a02", "신길동", "DESIGN"),
							  new QuizSawon("b01", "마길동", "HUMANRESOURCES")};
		for(QuizSawon sawon : sawons) {
			System.out.println(sawon);
		}
	}
}