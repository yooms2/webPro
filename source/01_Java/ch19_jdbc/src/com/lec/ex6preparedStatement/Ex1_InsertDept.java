package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex1_InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		System.out.print("�߰��� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		System.out.print("�߰��� �μ����� ?");
		String dname = sc.next();
		System.out.print("�߰��� �μ���ġ�� ?");
		String loc = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql); // SQL ���� ��ü
			pstmt.setInt(1, deptno); // deptno�� int�� setInt�Լ� �̿�
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
//			int result = stmt.executeQuery(sql);
			int result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
			}
		}
	}
}
