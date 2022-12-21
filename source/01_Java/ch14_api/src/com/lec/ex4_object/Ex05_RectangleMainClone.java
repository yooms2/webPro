package com.lec.ex4_object;

public class Ex05_RectangleMainClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle(); // r1:w=0, h=0, color="����"
		r1.setHeight(5); r1.setWidth(10); // w=10, h=5, color="����"
		Rectangle r2 = (Rectangle) r1.clone(); // ���� new Rectangle(10, 5, "����")
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " + r2);
		if(r1.equals(r2)) {
			System.out.println("���� ������ �簢�� ��ü(������ �Ѱ��� ���縦 �Ѱ���?)");
		}else {
			System.out.println("�ٸ� ������ �簢�� ��ü");
		}
		if(r1==r2) {
			System.out.println("�����Ѱ� �ƴϰ� ����");
		}else {
			System.out.println("�ٸ� �ּ�");
		}
		if(r1!=r2 && r1.equals(r2)) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
}
