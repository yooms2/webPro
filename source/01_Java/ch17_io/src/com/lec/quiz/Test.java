package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> bro = new ArrayList<Friend>();
		bro.add(new Friend("ȫ�浿", "010-9999-1234", "����� ��걸", new Date(new GregorianCalendar(0, 4, 22).getTimeInMillis())));
		bro.add(new Friend("�ű浿", "010-9999-9999", "����� ������", new Date(new GregorianCalendar(0, 3, 5).getTimeInMillis())));
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("�˻��� �ּ� �� ���� 2�ڸ� (����:x)");
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
				System.out.println("�˻��� �ּ� �� ���ڴ� �����ϴ�");
			}
		}
	}
}
