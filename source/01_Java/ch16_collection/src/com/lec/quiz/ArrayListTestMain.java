package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		//customers.add(new Customer("ȫ�浿", "010-9999-9999", "����� ��걸 ��굿"));
		//customers.add(new Customer("�踶��", "010-8888-8888", "����� ������ ���굿"));
		Scanner sc = new Scanner(System.in);
		String answer, list;
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
				System.out.println("�ּҸ� �Է��ϼ���");
				sc.nextLine();
				address = sc.nextLine();
				customers.add(new Customer(name, tel, address));
				System.out.println("ȸ�������� �Ϸ� �Ǿ����ϴ�");
			}
		}while(! list.equalsIgnoreCase("n")); 
		System.out.println("<��� ȸ�� ����>");
		if(customers.isEmpty()) {
			System.out.println("����");
		}else {
			for(Customer customer : customers) {
				System.out.println(customer);
			}
		}
	}
}
