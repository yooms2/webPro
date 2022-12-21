package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���
public class Ex08_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮��"),
							new Friend("��浿", "010-8888-9999", "12-14", "���� ����"),
							new Friend("�ű浿", "010-9999-7777", "02-10", "���� ���"),
							new Friend("���浿", "010-6666-6666", "03-03", "��õ �۵�")};
		// �ý������κ��� ������ ������ �޾ƿͼ� "��2��-��2�ڸ�" ������ ��Ʈ������ �����
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now.getTime());
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�");
		for(Friend friend : friends) {
			if(today.equals(friend.getBirth())) {
				System.out.println(friend);
				none = false;
			}
		} // for
//		for(int idx=0 ; idx<friends.length ; idx++) {
//			String birth = friends[idx].getBirth();
//			if(today.equals(birth)) {
//				System.out.println(friends[idx]);
//				none = false; // �Ѹ��̻� ��� �� none�� false
//			} // if
//		} // for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	} // main
} // class
