package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾� �μ����� ���
public class Ex1_selectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + "�� �μ������� ������ �����ϴ�");
				System.out.println("�μ��� : " + dname);
				System.out.println("�μ���ġ : " + loc);
			} else {
				System.out.println("�ش� �μ��� �������� �ʽ��ϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
	}
}
