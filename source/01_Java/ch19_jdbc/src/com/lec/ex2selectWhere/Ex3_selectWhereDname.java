package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �μ��̸��� �Է¹޾� �μ����� ���
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select���϶��� ������� rs�� ����
		System.out.print("���ϴ� �μ��̸���?");
		String dname = sc.next();
		String sql = "SELECT * FROM DEPT WHERE DNAME=UPPER('"+dname+"')";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // stmt.executeQuery() : select�� ���� ��
			if(rs.next()) {
				System.out.println("�μ���ȣ : " + rs.getInt("deptno"));
				System.out.println("�μ��� : " + dname);
				System.out.println("�ٹ��� : " + rs.getString("loc"));
			} else {
				System.out.println("�ش� �μ� �̸��� �������� �ʽ��ϴ�");
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
