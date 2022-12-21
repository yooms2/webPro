package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮��"),
							new Friend("��浿", "010-8888-9999", "12-14", "���� ����"),
							new Friend("�ű浿", "010-9999-7777", "02-10", "���� ���"),
							new Friend("���浿", "010-6666-6666", "03-03", "��õ �۵�")};
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1; // 3
		int day = now.get(Calendar.DAY_OF_MONTH); // 3
		String monthStr = month<10 ? "0"+month : ""+month; // "" + 12 => "12"
		// monthStr = month<10 ? "0"+month : String.valueOf(month); // "12"
		String dayStr = day < 10 ? "0"+day : ""+day;
		String today = monthStr + "-" + dayStr; // "12-14"
		System.out.println(today); // 3-3
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�");
		for(int idx=0 ; idx<friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if(today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false; // �Ѹ��̻� ��� �� none�� false
			} // if
		} // for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	} // main
} // class
