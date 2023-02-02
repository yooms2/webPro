package com.lec.quiz2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		String list;
		OutputStream os = null;
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = "12-21";
		String name, tel, address;
		String birth;
		
		
		do {
			System.out.print("ȸ������ �Ͻðڽ��ϱ�(y/n)?");
			list = sc.next();
			if(list.equalsIgnoreCase("y")) {
				System.out.print("�̸��� �Է��ϼ���");
				name = sc.next();
				System.out.print("��ȭ��ȣ�� �Է��ϼ���");
				tel = sc.next();
				System.out.print("������ �Է��ϼ���(yyyy-MM-dd)");
				birth = sc.next();// "1995-12-10"
				
				StringTokenizer tokenizer = new StringTokenizer(birth, "-");//"1995"/"12"/"10"
				int year = Integer.parseInt(tokenizer.nextToken());//1995
				
				int month = Integer.parseInt(tokenizer.nextToken());
				int day = Integer.parseInt(tokenizer.nextToken());
				
				System.out.print("�ּҸ� �Է��ϼ���");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Member(name, tel, new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis()), address));
				System.out.println("ȸ�������� �Ϸ� �Ǿ����ϴ�");
			}
		}while(! list.equalsIgnoreCase("n"));
		//  ���� ȸ������(ArrayList add) �Ʒ��� ���Թ��� ȸ�������� ���� ���
		
		try {
			os = new FileOutputStream("txtFile/member.txt", true);
			if(members.isEmpty()) {
				String msg = "��� ����";
				System.out.println(msg);
				os.write(msg.getBytes());
			}else {
				for(Member member : members) {
					System.out.print(member.toString());
					os.write(member.toString().getBytes());
				}
			}
			String msg = "..... ���� " + members.size() + "�� ����";
			System.out.println(msg);
			os.write(msg.getBytes());
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}