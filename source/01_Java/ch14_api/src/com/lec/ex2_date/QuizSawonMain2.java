package com.lec.ex2_date;

public class QuizSawonMain2 {
	public static void main(String[] args) {
		QuizSawon2[] sawons = {new QuizSawon2("a01", "ȫ�浿", Dept.COMPUTER),
							  new QuizSawon2("a02", "�ű浿", Dept.ACCOUNTING),
							  new QuizSawon2("b01", "���浿", Dept.HUMANRESOURCES)};
		for(QuizSawon2 sawon : sawons) {
			System.out.println(sawon);
		}
	}
}