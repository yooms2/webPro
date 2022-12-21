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
		// 특정한 y년 m월 d일로 초기화
		// date = new Date(y-1900, m-1, d);
		date = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override
	public String toString() {
		SimpleDateFormat sw = new SimpleDateFormat("yyyy년,M월,d일(E)");
		if(part.length() > 8)
			return "[사번]" + saNo + "\t[이름]" + name + "\t[부서]" + part + "\t[입사일]" + sw.format(date);
		else
			return "[사번]" + saNo + "\t[이름]" + name + "\t[부서]" + part + "\t\t[입사일]" + sw.format(date);
	}
}
