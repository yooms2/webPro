package com.lec.ex6_member;

public class Member {
	private String id, pw, name, email, address, birth;
	private char gender;
	public Member() {}
	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public void print() {
		System.out.println("���̵� : " + id);
		System.out.println("��й�ȣ : " + pw);
		System.out.println("�̸� : " + name);
		System.out.println("�̸��� : " + email);
		System.out.println("�ּ� : " + address);
		System.out.println("���� : " + birth);
		System.out.println("���� : " + (gender=='m' ? "����" : (gender=='f' ? "����" : "�ܰ���")));
	}
	public String infoString() {
		String result = "���̵� : " + id;
		result += "\n��й�ȣ : " + pw;
		result += "\n�̸� : " + name; 
		result += "\n�̸��� : " + email; 
		result += "\n�ּ� : " + address; 
		result += "\n���� : " + birth; 
		result += "\n���� : " + (gender=='m' ? "����" : (gender=='f' ? "����" : "�ܰ���"));
		return result;
	}
}
