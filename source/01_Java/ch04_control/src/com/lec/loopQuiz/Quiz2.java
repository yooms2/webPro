package com.lec.loopQuiz;

public class Quiz2 {
	public static void main(String[] args) {
		int etot = 0;
		for(int i=1 ; i<6 ; i++) {
			System.out.print(i+i);
			if(i != 5) {
				System.out.print('+');
			} //if
			etot += i+i ;
		} //for
		System.out.println("=" + etot + "(Â¦¼öÀÇ ÇÕ)");
		
		int otot = 0 ;
		for(int i=1 ; i<6 ; i++) {
			System.out.print(2*i-1);
			if(i != 5) {
				System.out.print('+');
			} //if
			otot += 2*i-1 ;
		} //for
		System.out.println("=" + otot + "(È¦¼öÀÇ ÇÕ)");
	} //main
} //class
