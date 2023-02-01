package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 수정할 부서번호를 받아 존재하는 부서번호인지 확인 후, 부서명, 근무지 입력받아 update
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			while(true) {
				System.out.print("수정할 부서번호는?");
				int deptno = sc.nextInt();
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("cnt");
				if(cnt==0) {
					System.out.println("존재하지 않는 부서 입니다");
				} else {
					System.out.print("수정할 부서명은?");
					String dname = sc.next();
					System.out.print("수정할 위치는?");
					String loc = sc.next();
					String updateQuery = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", dname, loc, deptno);
					int result = stmt.executeUpdate(updateQuery);
					System.out.println(result>0 ? deptno + "번 부서정보 수정성공" : "해당부서가 존재하지 않아 수정 실패");
					break;
				}
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