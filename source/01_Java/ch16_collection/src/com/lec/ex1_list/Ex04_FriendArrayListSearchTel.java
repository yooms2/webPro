package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex04_FriendArrayListSearchTel {
	public static void main(String[] args) {
		// Friend[] friends = new Friend[5];
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999"));
		friends.add(new Friend("�ű浿", "010-8888-9999", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis())));
		friends.add(new Friend("��浿", "02-717-7777"));
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ�(���� : x)?");
			String searchTel = sc.next(); // 8888
			if(searchTel.equalsIgnoreCase("x"))
				break;
			for(Friend friend : friends) {
				String tel = friend.getTel();
				String postTel = tel.substring(tel.lastIndexOf("-")+1);
				if(searchTel.equals(postTel)) {
					System.out.println(friend);
					searchOk = true;
				}
			} // for
			if(! searchOk) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ ���ڸ��� �����ϴ�");
			}
		}
	}
}
