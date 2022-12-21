package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		// Friend[] friends = new Friend[5];
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999"));
		friends.add(new Friend("�ű浿", "010-8888-9999", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis())));
		friends.add(new Friend("��浿", "02-717-7777"));
		for(int i=0 ; i<friends.size() ; i++) {
			System.out.println(friends.get(i));
		}
		System.out.println("��ȭ��ȣ�� ���");
		for(int i=0 ; i<friends.size() ; i++) {
			System.out.println(friends.get(i).getTel());
		}
		for(Friend friend : friends) {
			System.out.println(friend.getTel());
		}
	}
}
