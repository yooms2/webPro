package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		Connection conn = null; // db ���� ��ü
		Statement stmt = null; // sql ������ ��ü
		ResultSet rs = null;  // select ���� ����� ���� ��ü
		String sql = "SELECT * FROM PERSONAL"; // ctrl + shift + X : �빮��, ctrl + shift + Y :�ҹ���
		try {
			Class.forName(driver); // 1�ܰ� ����̹��ε�
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2�ܰ� DB���ᰴü ����
			stmt = conn.createStatement(); // 3�ܰ� SQL���� ��ü
			rs = stmt.executeQuery(sql); // 4�ܰ� SQL���� + 5�ܰ� SQL��� �ޱ�
			// 6�ܰ� ��� �޾� ���ϴ� ���� ����
			System.out.println("���\t�̸�\t��å\t�����\t�Ի���\t�޿�\t��\t�μ���ȣ");
			while(rs.next()) {
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname"); // pname Ÿ��Ʋ�� �ʵ� ��
				String job = rs.getString(3); // 3��° �ʵ� ��(job)
				int manager = rs.getInt("manager"); //null���� 0
				Date startdate = rs.getDate("startdate");
				// String startdate = rs.getString("startdate");
				Timestamp startdate1 = rs.getTimestamp("startdate"); // 0��0��0��
				int pay = rs.getInt("pay");
				int bonus = rs.getInt("bonus");
				int dno = rs.getInt("dno");
				if(job.length() <= 7) {
					System.out.printf("%d\t%s\t%s\t\t%d\t %tf\t %d\t%d\t%d\n", pno, pname, job, manager, startdate, pay, bonus, dno);
				} else {
					System.out.printf("%d\t%s\t%s\t%d\t %TF\t %d\t%d\t%d\n", pno, pname, job, manager, startdate, pay, bonus, dno);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7�ܰ� ��������
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
