package com.lec.loop;

public class Ex05_breakContunue {
	public static void main(String[] args) {
		for(int i=1 ; i<=5 ; i++) {
			if(i == 3)
				//break;  // �ݺ��� ���� ���� ����
				continue; // ���������� �ö�
			System.out.println(i);
		}
	}
}
