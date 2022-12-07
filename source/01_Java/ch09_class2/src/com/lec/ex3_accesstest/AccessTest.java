package com.lec.ex3_accesstest;

public class AccessTest {
	private int privateMember; // ���� Ŭ������������
	protected int protectedMember; // ���� ��Ű���� ��ӹ��� Ŭ���¼� ���
	int defaultMember; // ����Ʈ �������� : ���� ��Ű�������� ���
	public int publicMember; // �ƹ������� ���
	private void privateMethod() { // ���� Ŭ������������
		System.out.println("private �޼ҵ�");
	}
	protected void protectedMethod() {
		System.out.println("protected �޼ҵ�");
	}
	void defaultMethod() {
		System.out.println("default �żҵ�");
	}
	public void publicMethod() {
		System.out.println("public �޼ҵ�");
	}
}
