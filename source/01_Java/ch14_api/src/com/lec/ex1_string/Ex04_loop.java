package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_loop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("I:input / U:update / X:exit");
			fn = scanner.next(); // "i" "u" "x"
			switch(fn) {
			case "i": case "I":
				System.out.println("입력로직"); break;
			case "u": case "U":
				System.out.println("업데이트로직"); break;
			}
		}while(!fn.equalsIgnoreCase("X"));
//		}while(!fn.equals("x") && !fn.equals("X"));
	}
}
