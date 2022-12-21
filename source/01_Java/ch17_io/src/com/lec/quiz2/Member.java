package com.lec.quiz2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date birthday;
	private String address;
	public Member() {}
	public Member(String name, String tel, Date birthday, String address) {
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
	}
	@Override
	public String toString() {
		if(birthday!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd생");
			return "[name]=" + name + "[tel]=" + tel + "[birthday=]" + sdf.format(birthday) + "[address=]" + address+"\n";
		}
		return "[name]=" + name + "[tel]=" + tel + "[birthday=]" + "생일모름" + "[address=]" + address+"\n";
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
