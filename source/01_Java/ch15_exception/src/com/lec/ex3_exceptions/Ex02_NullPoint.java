package com.lec.ex3_exceptions;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex02_NullPoint {
	public static void main(String[] args) {
		Friend hong = new Friend("ȫ�浿", "010-9999-9999", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis()));
		System.out.println(hong);
		Friend kim = new Friend("��浿", "010-8888-8888");
		System.out.println(kim);
	}
}
