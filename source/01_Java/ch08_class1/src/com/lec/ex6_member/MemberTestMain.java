package com.lec.ex6_member;

public class MemberTestMain {
	public static void main(String[] args) {
//		int[] arr = new int[7];
//		for(int a : arr) {
//			System.out.println(a);
//		}
		Member a1 = new Member("aaa", "xxx", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", 'm');
		Member[] member = new Member[2];
		member[0] = a1;
		member[1] = new Member("bbb", "zzz", "ȫ���", "hong1@company.com", "���� ���빮��", "2020-02-02",'f');
		for(Member a : member) {
			System.out.println(a.infoString());
		}
	}
}
