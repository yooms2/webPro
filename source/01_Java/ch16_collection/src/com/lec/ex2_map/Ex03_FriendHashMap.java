package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Scanner;

import com.lec.ex1_list.Friend;

public class Ex03_FriendHashMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999", new Friend("ȫ�浿", "010-9999-9999"));
		friends.put("010-8888-8888", new Friend("��浿", "010-8888-8888"));
		friends.put("010-7777-7777", new Friend("�ű浿", "010-7777-7777"));
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("�˻��ϰ��� �ϴ� ��ȭ��ȣ�� (����x) ? ");
			String searchTel = sc.next();
			if(searchTel.equalsIgnoreCase("x"))
				break;
			if(friends.get(searchTel) != null) {
				System.out.println("�˻� ��� : " + friends.get(searchTel));
			}else {
				System.out.println("�˻��� ��ȭ��ȣ�� �����ϴ�");
			}
		} // while
		sc.close();
	}
}
