package com.lec.ex;
// 1~10���� ������ �հ� �� ����� ¦������ Ȧ������ ���
public class Ex01 {
	public static void main(String[] args) {
		int tot = 0 ;
		for(int i=1 ; i<=10 ; i++) {
			tot += i ;
		}
		System.out.println("1~10���� �������� " + tot + "�Դϴ�");
		System.out.println( (tot%2 == 0) ?  "¦���Դϴ�" : "Ȧ���Դϴ�");
		// -------------------------------------------------------
		tot = 0 ;
		for(int i=10 ; i<=100 ; i++) {
			tot += i ;
		}
		System.out.println("10~100���� �������� " + tot + "�Դϴ�");
		System.out.println( (tot%2 != 0) ?  "¦���Դϴ�" : "Ȧ���Դϴ�");
	}
}
