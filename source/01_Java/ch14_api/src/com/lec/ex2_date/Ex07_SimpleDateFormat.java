package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex07_SimpleDateFormat {
	public static void main(String[] args) {
		// Date date = new Date(2022-1900, 10, 28, 9, 30); // 2022.11.28
		Date date = new Date(new GregorianCalendar(2022, 10, 28, 9, 30).getTimeInMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yy-MM-dd(E) a hh:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("������ ������ D��°���Դϴ�");
		SimpleDateFormat sdf5 = new SimpleDateFormat("�̹��ִ� ������ w��° ���Դϴ�");
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		System.out.println(sdf5.format(date));
	}
	
}
