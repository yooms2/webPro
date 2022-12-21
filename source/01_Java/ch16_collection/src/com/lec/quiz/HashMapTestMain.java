package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapTestMain {
	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		//customers.put("010-9999-9999", new Customer("ȫ�浿", "010-9999-9999", "����� ��걸 ��굿"));
		//customers.put("010-8888-8888", new Customer("�踶��", "010-8888-8888", "����� ������ ���굿"));
		Scanner sc = new Scanner(System.in);
		String list;
		String name;
		String tel;
		String address;
		do {
			System.out.println("ȸ������ �Ͻðڽ��ϱ�(y/n)?");
			list = sc.next();
			if(list.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��ϼ���");
				name = sc.next();
				System.out.println("��ȭ��ȣ�� �Է��ϼ���");
				tel = sc.next();
				if(customers.get(tel) != null) {
					System.out.println("�̹� ���ԵǾ� �ִ� ��ȭ��ȣ �Դϴ�");
					continue;
				}
				System.out.println("�ּҸ� �Է��ϼ���");
				sc.nextLine();
				address = sc.nextLine();
				customers.put(tel, new Customer(name, tel, address));
				System.out.println("ȸ�������� �Ϸ� �Ǿ����ϴ�");
			}
		}while(! list.equalsIgnoreCase("n"));
		System.out.println("<��� ȸ�� ����>");
		if(customers.isEmpty()) {
			System.out.println("����");
		}else {
		Iterator<String> iterator = customers.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(customers.get(key));
			}
		}
	}
}