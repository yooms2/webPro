package com.lec.ex6_wrapper;
// Wrapper Ŭ���� : Integer, Double, Long, Boolean... ���ʵ����͸� ��ü �����ͷ� ��ȯ�� Ŭ����
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		Integer iObj = 10; // new Integer (10); �ڵ� ��ü ����
		int sum = i + iObj;
		// int sum = i + iObj.intValue(); // i + iObj
		System.out.println("���� " + sum);
		System.out.println(iObj.equals(10));
	}
}
