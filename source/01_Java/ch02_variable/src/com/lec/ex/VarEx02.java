package com.lec.ex;
// println() : �ܼ�â ���(��������)
// print() : �ܼ�â ���(���� ������)
// printf() : �ܼ�â ���(���� ����)
public class VarEx02 {
	public static void main(String[] args) {
		//  Ÿ�� ������ �Ҵ翬���� ��;
		int i = 10;
		byte j = 127;
		double h = 10.15;
		i = 100;
		System.out.println("i=" + i + "\t j=" + j + "\t h="+h);
		System.out.printf("i=%d \t j=%d \t h=%.1f\n", i, j, h);
		char c1 = 'A';
		char c2 = 'ȫ';
		// %c:����, %s:���ڿ�, %d:����, %f:�Ǽ�, %b:boolean
		System.out.printf("c1=%c \t c2=%c\n", c1, c2);
		System.out.printf("c1=%d \t c2=%d\n", (int)c1, (int)c2);
		System.out.println("���α׷� ��");
	}
}
