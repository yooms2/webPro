package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class QuizSawon {
	private String saNo;
	private String name;
	private String part;
	private Date date;  
	public QuizSawon() { }
	public QuizSawon(String saNo, String name, String part) {
		this.saNo = saNo;
		this.name = name;
		this.part = part;
		date = new Date();
	}
	public QuizSawon(String saNo, String name, String part, int y, int m, int d) {
		this.saNo = saNo;
		this.name = name;
		this.part = part;
		// Ư���� y�� m�� d�Ϸ� �ʱ�ȭ
		// date = new Date(y-1900, m-1, d);
		date = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override
	public String toString() {
		SimpleDateFormat sw = new SimpleDateFormat("yyyy��,M��,d��(E)");
		if(part.length() > 8)
			return "[���]" + saNo + "\t[�̸�]" + name + "\t[�μ�]" + part + "\t[�Ի���]" + sw.format(date);
		else
			return "[���]" + saNo + "\t[�̸�]" + name + "\t[�μ�]" + part + "\t\t[�Ի���]" + sw.format(date);
	}
}
