package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex11_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "�ں��� ���� ���� ��ҿ� �嵿��";
		String str2 = "100-90-85-76";
		StringTokenizer tokenizer1 = new StringTokenizer(str1); // �����ڴ� space
		StringTokenizer tokenizer2 = new StringTokenizer(str2, "-"); // �����ڴ� -
		System.out.println("tokenizer1�� ��ū ���� : " + tokenizer1.countTokens());
		System.out.println("tokenizer2�� ��ū ���� : " + tokenizer2.countTokens());
		while(tokenizer1.hasMoreTokens()) {
			System.out.println(tokenizer1.nextToken());
		}
		while(tokenizer2.hasMoreTokens()) {
			System.out.println(tokenizer2.nextToken());
		}
	}
}
