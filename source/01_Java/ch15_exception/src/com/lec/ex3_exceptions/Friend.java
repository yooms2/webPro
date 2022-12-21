package com.lec.ex3_exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date birthday;
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birthday) {
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		if(birthday != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			return "[�̸�]" + name + "\t[��ȭ]" + tel + "\t[����]" + sdf.format(birthday);
		}
		return "[�̸�]" + name + "\t[��ȭ]" + tel;
	}		
}
