package com.lec.ex4_product;

public class Product {
	private int serialNo; // ��ü ������ ��ȣ
	public static int count = 100; // static ���� = Ŭ�������� = ��������
	public Product() {
		serialNo = ++count;
	}
	public static void staticMethod() {
		System.out.println("static �޼ҵ� test");
	}
	public void infoPrint() {
		System.out.println("�ø����ȣ : " + serialNo + "\t��������count : " + count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
