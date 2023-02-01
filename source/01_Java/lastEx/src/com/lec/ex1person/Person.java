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
			System.out.print("1:입력 || 2:직업별조회 || 3:전체조회 || 그외:종료");
			fn = sc.next();
			switch(fn) {
			case "1" : // 이름, 직업명(jobs), 국, 영, 수 받아 insert
				sql = "INSERT INTO PERSON" + 
						" VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("이름은?");
					String pname = sc.next();
					pstmt.setString(1, pname);
					System.out.println("직업명은"+jobs+"?");
					pstmt.setString(2, sc.next());
					System.out.print("국어 점수는?");
					int kor = sc.nextInt();
					System.out.print("영어 점수는?");
					int eng = sc.nextInt();
					System.out.print("수학 점수는?");
					int mat = sc.nextInt();
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "입력성공" : "입력실패");
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
			case "2" : // 직업명 받아 직업 출력
				sql = "SELECT ROWNUM RN, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'번'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"        FROM PERSON P , JOB J WHERE P.JNO=J.JNO AND JNAME=?" + 
						"        ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("직업은" +jobs+"?");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) { // 직업별 출력
						System.out.println("rank\t이름\t직업\t국\t영\t수\t총점");
						do {
							int rn = rs.getInt("rn");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rn+"\t등"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						} while(rs.next());
					} else {
						System.out.println("해당 직업의 사람이 입력되지 않았습니다");
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
						"    FROM (SELECT PNAME||'('||PNO||'번'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"        FROM PERSON P , JOB J WHERE P.JNO=J.JNO" + 
						"        ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("rank\t이름\t직업\t국\t영\t수\t총점");
						do {
							int rank = rs.getInt("rn");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"등\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						} while(rs.next());
					} else {
						System.out.println("등록된 사람이 없습니다");
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
