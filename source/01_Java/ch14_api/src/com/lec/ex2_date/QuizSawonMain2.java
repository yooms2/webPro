package com.lec.ex2_date;

public class QuizSawonMain2 {
	public static void main(String[] args) {
		QuizSawon2[] sawons = {new QuizSawon2("a01", "홍길동", Dept.COMPUTER),
							  new QuizSawon2("a02", "신길동", Dept.ACCOUNTING),
							  new QuizSawon2("b01", "마길동", Dept.HUMANRESOURCES)};
		for(QuizSawon2 sawon : sawons) {
			System.out.println(sawon);
		}
	}
}