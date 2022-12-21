package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa"); list.add("aaa");
		System.out.println(list.get(0) + "/" + list.get(1)); // �ε����� key
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11"); // key�� ������ ��
		hashMap.put(12, "str12");
		hashMap.put(20, "str20");
		hashMap.put(33, "str33");
		System.out.println(11 + "key���� �����ʹ� " + hashMap.get(11));
		System.out.println(hashMap);
		hashMap.remove(12); // remove �ô� key�����θ� �̿�
		System.out.println("remove �� : " + hashMap);
		hashMap.clear(); // ��� ������ ����
		System.out.println(hashMap.isEmpty() ? "������ ��� ����" : "������ ����");
		// ���
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "kim dongil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator(); // �ݺ���
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "�� �����ʹ� " + hashMap.get(key));
		}
	}
}
