package com.lec.ex;
// �������� : &&(AND), ||(OR), !
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("&& : (i<j) && (++j>h) ��" + ((i<j) && (++j>h)) );
		System.out.println("j = " + j); // j=11
		// &&������ ��� ������ false�� ��� ������ ���� ���� �ʴ´�.
		System.out.println("&& : (i>j) && (++j>h) ��" + ((i>j) && (++j>h)) );
		System.out.println("j = " + j);
		
		System.out.println("|| : (i<j) || (++j>h) ��" + ((i<j) || (++j>h)) );
		System.out.println("j = " + j); // j=11
		// &&������ ��� ������ false�� ��� ������ ���� ���� �ʴ´�.
		System.out.println("|| : (i>j) || (++j>"
				+ "h) ��" + ((i>j) || (++j>h)) );
		System.out.println("j = " + j);
	}
}
