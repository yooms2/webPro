package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		// ����, ����, ���� ���� �Ҵ�
		// ����, ���
		// ������ ���
		int kor = 100;
		int eng = 99;
		int mat = 100;
		int tot = kor + eng + mat; // ����299
		double avg = (double)tot / 3;
		System.out.println("���� : "+kor+"\t���� : "+eng+"\t���� : "+mat);
		System.out.printf("���� : %d\t��� : %.2f\n", tot, avg);
		
	}

}
