package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		//customers.add(new Customer("홍길동", "010-9999-9999", "서울시 용산구 용산동"));
		//customers.add(new Customer("김마동", "010-8888-8888", "서울시 마포구 노고산동"));
		Scanner sc = new Scanner(System.in);
		String answer, list;
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
				System.out.println("주소를 입력하세요");
				sc.nextLine();
				address = sc.nextLine();
				customers.add(new Customer(name, tel, address));
				System.out.println("회원가입이 완료 되었습니다");
			}
		}while(! list.equalsIgnoreCase("n")); 
		System.out.println("<모든 회원 정보>");
		if(customers.isEmpty()) {
			System.out.println("없다");
		}else {
			for(Customer customer : customers) {
				System.out.println(customer);
			}
		}
	}
}
