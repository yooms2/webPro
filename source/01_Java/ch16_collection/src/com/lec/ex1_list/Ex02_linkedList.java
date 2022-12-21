package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_linkedList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); // 0�� �ε���
		linkedList.add("str1"); // 1�� �ε��� -> 0�� �ε���
		linkedList.add("str2"); // 2�� �ε��� -> 1�� �ε���
		linkedList.remove("str0"); // 0�� �ε��� ����
		for(int i=0 ; i<linkedList.size() ; i++) {
			System.out.println(i + " : " + linkedList.get(i));
		}
		linkedList.clear();
		if(linkedList.isEmpty()) {
			System.out.println("�����Ͱ� �����ϴ�");
		}else {
			for(String temp : linkedList) {
				System.out.println(temp);
			}
		}
	}
}
