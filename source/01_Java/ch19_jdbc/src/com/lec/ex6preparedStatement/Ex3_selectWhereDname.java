package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// �μ����� �޾� �ش� �μ� ����� ���(���, �̸�, ����̸�, �޿�, �޿����, ��簡 ���� ����� 
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT W.EMPNO, W.ENAME, NVL(M.ENAME, 'CEO') MANAGER, W.SAL, GRADE" + 
				"	 FROM EMP W, EMP M, DEPT D, SALGRADE" + 
				"    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO" + 
				"        AND W.SAL BETWEEN LOSAL AND HISAL" + 
				"        AND DNAME=UPPER(?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			System.out.print("�˻��ϰ��� �ϴ� �μ����� ?");
			pstmt.setString(1, sc.next());
			rs = pstmt.executeQuery();
			if(rs.next()) { // �ش�μ� ��� list�� ���
				System.out.println("���\t�����\t���\t�޿�\t�޿����");
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String manager = rs.getString("manager");
					int sal = rs.getInt("sal");
					int grade = rs.getInt("grade");
					System.out.printf("%d\t%s\t%s\t%d\t%d\n", empno, ename, manager, sal, grade);
				}while(rs.next());
			} else {
				System.out.println("�ش� ����� �����ϴ�");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
