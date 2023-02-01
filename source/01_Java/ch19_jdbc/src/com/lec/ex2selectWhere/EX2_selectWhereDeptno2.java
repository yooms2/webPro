package com.lec.ex2selectWhere;
// ����ڿ��� ���ϴ� �μ���ȣ�� �޾� �μ������� �Ѹ���, �ش� �μ��� ��������� ���
	// 1. �ش�μ���ȣ�� ���� ��� : �������� �ʴ� �μ��Դϴ�
	// 2. �ش�μ���ȣ�� �ִ� ��� : �μ������� ���
		// 2-1. �ش�μ� ����� �ִ� ��� : ������� ���
		// 2-2. �ش�μ� ����� ���� ��� : �ش� �μ� ���(���, �̸�, �޿�, ����̸�)�� �����ϴ�

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EX2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" +
			    " FROM EMP W, EMP M" +
			    " WHERE W.MGR=M.EMPNO AND W.DEPTNO=" + deptno;
		try {
			Class.forName(driver); // 1
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			stmt = conn.createStatement(); // 3 
			rs = stmt.executeQuery(sql1); // 4 + 5 select���϶��� ������� rs�� ����
			if(rs.next()) {
				System.out.println("���ϴ� �μ���ȣ : " + deptno);
				System.out.println("���ϴ� �μ��̸� : " + rs.getString("dname"));
				System.out.println("���ϴ� �μ���ġ : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println("���\t�̸�\t�޿�\t����");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getNString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					} while(rs.next());
				} else {
					System.out.println(deptno +"�� �μ� ����� �����ϴ�");
				}
			} else {
				System.out.println("�ش� �μ��� �����ϴ�");
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
