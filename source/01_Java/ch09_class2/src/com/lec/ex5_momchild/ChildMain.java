package com.lec.ex5_momchild;

public class ChildMain {
	public static void main(String[] args) {
		Child child1 = new Child("ù° �浿��");
		Child child2 = new Child("��° ������");
		Child child3 = new Child("��° �ʼ���");
		System.out.println("ù° ���� ���� : " + child1.momPouch.money);
		System.out.println("��° ���� ���� : " + child2.momPouch.money);
		System.out.println("��° ���� ���� : " + child3.momPouch.money);
		System.out.println("static ���� : " + Child.momPouch.money);
		child1.takeMoney(1000);
		System.out.println("ù° ���� ���� : " + child1.momPouch.money);
		System.out.println("��° ���� ���� : " + child2.momPouch.money);
		System.out.println("��° ���� ���� : " + child3.momPouch.money);
		System.out.println("static ���� : " + Child.momPouch.money);
		child2.takeMoney(1000);
		child3.takeMoney(1000); // ��°�� �� ��
	}
}
