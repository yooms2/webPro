package com.lec.quiz2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class MemberTestMain_printWriter {
	public static void main(String[] args) {
		String list;
		PrintWriter printWriter = null;
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
			printWriter = new PrintWriter("txtFile/member.txt");
			if(members.isEmpty()) {
				String msg = "��� ����";
				System.out.println(msg);
				printWriter.println("��� ����");
			}else {
				for(Member member : members) {
					System.out.print(member.toString());
//					printWriter.write(member.toString());
					printWriter.println(member.toString());
				}
			}
			String msg = "..... ���� " + members.size() + "�� ����";
			System.out.println(msg);
//			printWriter.write(msg);
			printWriter.println("..... ���� " + members.size() + "�� ����");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(printWriter!=null) printWriter.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
