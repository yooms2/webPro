package com.lec.ex;
// 1~10���� ������ �հ� �� ����� ¦������ Ȧ������ ���
public class Ex02 {
	private static int sum(int from, int to) {
		int sum = 0 ; // ������ ����
		for(int i=from ; i<=to ; i++) {
			sum += i ;
		}
		return sum ;
	}
	private static String evenOdd(int value) {
		String result = value%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�" ;
		return result ;
	}
	public static void main(String[] args) {
		int tot = sum (1, 10);
		System.out.println("1~10���� �������� " + tot + "�Դϴ�");
		System.out.println( evenOdd(tot) );
		// -------------------------------------------------------
		tot = sum(10, 100) ;
		System.out.println("10~100���� �������� " + tot + "�Դϴ�");
		System.out.println( evenOdd(tot) );
	}
}
