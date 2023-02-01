package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ������ �μ���ȣ�� �μ���, �ٹ����� �Է¹޾� update
public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		System.out.print("������ �μ���ȣ��?");
		int deptno = sc.nextInt();
		System.out.print("������ �μ�����?");
		String dname = sc.next();
		System.out.print("������ ��ġ��?");
		String loc = sc.next();
		String updateQuery = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", dname, loc, deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(updateQuery);
			System.out.println(result>0 ? deptno + "�� �μ����� ��������" : "�ش�μ��� �������� �ʾ� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
