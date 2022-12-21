package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapTestMain {
	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		//customers.put("010-9999-9999", new Customer("홍길동", "010-9999-9999", "서울시 용산구 용산동"));
		//customers.put("010-8888-8888", new Customer("김마동", "010-8888-8888", "서울시 마포구 노고산동"));
		Scanner sc = new Scanner(System.in);
		String list;
		String name;
		String tel;
		String address;
		do {
			System.out.println("회원가입 하시겠습니까(y/n)?");
			list = sc.next();
			if(list.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요");
				name = sc.next();
				System.out.println("전화번호를 입력하세요");
				tel = sc.next();
				if(customers.get(tel) != null) {
					System.out.println("이미 가입되어 있는 전화번호 입니다");
					continue;
				}
				System.out.println("주소를 입력하세요");
				sc.nextLine();
				address = sc.nextLine();
				customers.put(tel, new Customer(name, tel, address));
				System.out.println("회원가입이 완료 되었습니다");
			}
		}while(! list.equalsIgnoreCase("n"));
		System.out.println("<모든 회원 정보>");
		if(customers.isEmpty()) {
			System.out.println("없다");
		}else {
		Iterator<String> iterator = customers.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(customers.get(key));
			}
		}
	}
}