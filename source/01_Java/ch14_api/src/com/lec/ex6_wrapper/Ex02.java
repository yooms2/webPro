package com.lec.ex6_wrapper;
// java com.lec.ex6_wrapper.Ex02 10 20 30 1 ����
// ��� : ���� ���� ���� : 4
//		 ���� ���� �� : 61
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("���� ���� ���� : " + args.length);
		int total = 0; // ��������
		for(int i=0 ; i<args.length ; i++) {
			total += Integer.parseInt(args[i]); // total = total + Integer.parseInt(args[i]);
			System.out.println(args[i]);
		}
		System.out.println("���� ���� �� : " + total);
	}
}
