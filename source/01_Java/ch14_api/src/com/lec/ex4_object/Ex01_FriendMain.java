package com.lec.ex4_object;

public class Ex01_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮��"),
							new Friend("��浿", "010-8888-9999", "12-26", "���� ����"),
							new Friend("�ű浿", "010-9999-7777", "02-10", "���� ���"),
							new Friend("���浿", "010-6666-6666", "03-03", "��õ �۵�")};
		for(Friend friend : friends) {
			// �̸� : ȫ�浿 ��ȭ : 010-9999-9999 ���� : 12-14 �ּ� : ���� ���빮
//			System.out.printf("[�̸�]:%s\t[��ȭ]:%s\t[����]:%s\t[�ּ�]:%s\n", 
//					friend.getName(), friend.getTel(), friend.getBirth(), friend.getAdderss());
			System.out.println(friend);
		}
	}
}
