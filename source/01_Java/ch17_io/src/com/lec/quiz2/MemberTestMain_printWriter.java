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
			System.out.print("회원가입 하시겠습니까(y/n)?");
			list = sc.next();
			if(list.equalsIgnoreCase("y")) {
				System.out.print("이름을 입력하세요");
				name = sc.next();
				System.out.print("전화번호를 입력하세요");
				tel = sc.next();
				System.out.print("생일을 입력하세요(yyyy-MM-dd)");
				birth = sc.next();// "1995-12-10"
				
				StringTokenizer tokenizer = new StringTokenizer(birth, "-");//"1995"/"12"/"10"
				int year = Integer.parseInt(tokenizer.nextToken());//1995
				
				int month = Integer.parseInt(tokenizer.nextToken());
				int day = Integer.parseInt(tokenizer.nextToken());
				
				System.out.print("주소를 입력하세요");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Member(name, tel, new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis()), address));
				System.out.println("회원가입이 완료 되었습니다");
			}
		}while(! list.equalsIgnoreCase("n"));
		//  위는 회원가입(ArrayList add) 아래는 가입받은 회원정보를 파일 출력
		
		try {
			printWriter = new PrintWriter("txtFile/member.txt");
			if(members.isEmpty()) {
				String msg = "멤버 없음";
				System.out.println(msg);
				printWriter.println("멤버 없음");
			}else {
				for(Member member : members) {
					System.out.print(member.toString());
//					printWriter.write(member.toString());
					printWriter.println(member.toString());
				}
			}
			String msg = "..... 이하 " + members.size() + "명 가입";
			System.out.println(msg);
//			printWriter.write(msg);
			printWriter.println("..... 이하 " + members.size() + "명 가입");
			
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
