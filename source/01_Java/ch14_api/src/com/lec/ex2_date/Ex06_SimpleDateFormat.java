package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex06_SimpleDateFormat {
	public static void main(String[] args) {
		Date nowDate = new Date();
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar(2022,1,1);
		/* yyyy(�⵵ 4�ڸ�) yy(�⵵ 2�ڸ�) MM(03) M(3) dd(08) d(8)
		 * E(����) a(����/����) H(24��) h(12��) m(��) s(��) 
		 * w(�̹��⵵�� ���° ������) W(�̹� ���� ���° ������) D(������ ���° ��) */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E) a hh�� mm�� ss��");
		String dateStr = sdf.format(nowDate);
		String calStr = sdf.format(nowCal.getTime()); // getTime : Calendar gregorian Date������ ��ȯ
		String gcStr = sdf.format(nowGc.getTime());
		System.out.println(dateStr);
		System.out.println(calStr);
		System.out.println(gcStr);
	}
}
