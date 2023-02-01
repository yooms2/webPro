package com.lec.ex1person;

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
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>();
		try {
			Class.forName(driver);
			sql = "SELECT JNAME FROM JOB";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				
			}
		}
//		System.out.println(jobs);
		do {
			System.out.print("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = sc.next();
			switch(fn) {
			case "1" : // �̸�, ������(jobs), ��, ��, �� �޾� insert
				sql = "INSERT INTO PERSON" + 
						" VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("�̸���?");
					String pname = sc.next();
					pstmt.setString(1, pname);
					System.out.println("��������"+jobs+"?");
					pstmt.setString(2, sc.next());
					System.out.print("���� ������?");
					int kor = sc.nextInt();
					System.out.print("���� ������?");
					int eng = sc.nextInt();
					System.out.print("���� ������?");
					int mat = sc.nextInt();
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "�Է¼���" : "�Է½���");
				}
				catch (Exception e) {
				} finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2" : // ������ �޾� ���� ���
				sql = "SELECT ROWNUM RN, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'��'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"        FROM PERSON P , JOB J WHERE P.JNO=J.JNO AND JNAME=?" + 
						"        ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("������" +jobs+"?");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) { // ������ ���
						System.out.println("rank\t�̸�\t����\t��\t��\t��\t����");
						do {
							int rn = rs.getInt("rn");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rn+"\t��"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						} while(rs.next());
					} else {
						System.out.println("�ش� ������ ����� �Էµ��� �ʾҽ��ϴ�");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (Exception e) {
						
					}
				}
				break;
			case "3" :
				sql = "SELECT ROWNUM RN, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'��'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"        FROM PERSON P , JOB J WHERE P.JNO=J.JNO" + 
						"        ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("rank\t�̸�\t����\t��\t��\t��\t����");
						do {
							int rank = rs.getInt("rn");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"��\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						} while(rs.next());
					} else {
						System.out.println("��ϵ� ����� �����ϴ�");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (Exception e) {
						
					}
				}
				break;
			}
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
			System.out.println("BYE");
	}
}
