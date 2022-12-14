package com.lec.ex4_object;

public class Friend {
	private String name;
	private String tel;
	private String birth; // "12-12"
	private String address;
	public Friend() { }
	public Friend(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	@Override
	public String toString() {
		return "[이름]" + name + "\t[전화]" + tel + "\t[생일]" + birth + "\t[주소]" + address;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
	public String getAdderss() {
		return address;
	}
}
