package com.lec.ex;
// ���׿����� (����)? (������ ���ϰ�� ���� ��) : (������ �����ϰ�� ���� ��)
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
		String result = (h%2 == 0)? "¦���Դϴ�" : "Ȧ���Դϴ�";
//		String result; // ¦Ȧ���ΰ��
//		if(h%2 == 0) {
//			result = "¦���Դϴ�";
//		}else {
//			result = "Ȧ���Դϴ�";
//		}
		System.out.println("����� "+result);
	}

}
