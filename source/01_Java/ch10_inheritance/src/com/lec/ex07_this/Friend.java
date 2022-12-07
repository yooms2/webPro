package com.lec.ex07_this;
// this.~ : �� ��ü�� ~
// this() : �� Ŭ������ ������ �Լ�
// super.~
// super()
public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("�Ű����� ���� ������");
	}
	public Friend(String name) {
		this(); // == Friend()
		this.name = name;
		System.out.println("�Ű����� �ϳ��� ������");
	}
	public Friend(String name, String tel) {
		this(name); // == Friend(name)
		this.tel = tel;
		System.out.println("�Ű����� �ΰ��� ������");
	}
	public String infoString() {
		return name + " : " + tel;
	}
}
