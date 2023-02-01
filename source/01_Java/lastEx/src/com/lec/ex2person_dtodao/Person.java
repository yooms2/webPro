package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<String> jobs = dao.jnameliList();
		do {
			System.out.print("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = sc.next();
			switch(fn) {
			case "1" : // �̸�, ������(jobs), ��, ��, �� �޾� insert
				System.out.print("�̸���?");
				String pname = sc.next();
				System.out.println("��������"+jobs+"?");
				String jname = sc.next();
				System.out.print("���� ������?");
				int kor = sc.nextInt();
				System.out.print("���� ������?");
				int eng = sc.nextInt();
				System.out.print("���� ������?");
				int mat = sc.nextInt();
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				break;
			case "2" : // ������ �޾� ���� ���
				System.out.println("������" +jobs+"?");
				jname = sc.next();
				ArrayList<PersonDto> dtos = dao.selectJname(jname);
				if(dtos.isEmpty()) {
					System.out.println(jname + "�������� ����� �����ϴ�");
				} else {
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3" :
				dtos = dao.selectAll();
				if(dtos.size()==0) {
					System.out.println("��ϵ� ����� �����ϴ�");
				} else {
					for(int idx=0 ; idx<dtos.size() ; idx++) {
						System.out.println(dtos.get(idx));
					}
				}
			}
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
