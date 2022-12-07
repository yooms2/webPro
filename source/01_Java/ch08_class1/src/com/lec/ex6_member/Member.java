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
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("이름 : " + name);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + address);
		System.out.println("생일 : " + birth);
		System.out.println("성별 : " + (gender=='m' ? "남자" : (gender=='f' ? "여자" : "외계인")));
	}
	public String infoString() {
		String result = "아이디 : " + id;
		result += "\n비밀번호 : " + pw;
		result += "\n이름 : " + name; 
		result += "\n이메일 : " + email; 
		result += "\n주소 : " + address; 
		result += "\n생일 : " + birth; 
		result += "\n성별 : " + (gender=='m' ? "남자" : (gender=='f' ? "여자" : "외계인"));
		return result;
	}
}
