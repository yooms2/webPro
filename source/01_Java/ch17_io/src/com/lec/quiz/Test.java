package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> bro = new ArrayList<Friend>();
		bro.add(new Friend("홍길동", "010-9999-1234", "서울시 용산구", new Date(new GregorianCalendar(0, 4, 22).getTimeInMillis())));
		bro.add(new Friend("신길동", "010-9999-9999", "서울시 마포구", new Date(new GregorianCalendar(0, 3, 5).getTimeInMillis())));
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색할 주소 앞 글자 2자리 (종료:x)");
			String searchAdd = sc.next();
			if(searchAdd.equalsIgnoreCase("x"))
				break;
			for(Friend frs : bro) {
				String address = frs.getAddress();
				String postAdd = address.substring(0, 2);
				if(searchAdd.equals(postAdd)) {
					System.out.println(frs);
				}
			}
			if(! searchOk) {
				System.out.println("검색한 주소 앞 글자는 없습니다");
			}
		}
	}
}
