package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;

public class CustomerDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int CUSTOMER_EXIST = 0;
	public static final int CUSTOMER_NONEXIST = 1;
	
	private static CustomerDao instance = new CustomerDao();
	public static CustomerDao getInstance() {
		return instance;
	}
	private CustomerDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 아이디 중복체크
	public int confirmId(String cid) {
		int result = CUSTOMER_EXIST;
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt == 0) {
				result = CUSTOMER_NONEXIST;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. 회원가입
	public int joinCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)" + 
				"	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setDate(8, dto.getCbirth());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
		} catch (SQLException e) {
			System.out.println("회원가입실패" + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 3. 상세보기(pk로 dto 가져오기)
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cpw = rs.getString("cpw");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				String cgender = rs.getString("cgender");
				Date cbirth = rs.getDate("cbirth");
				Date crdate = rs.getDate("crdate");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 4. 로그인
	public int loginCustomer(String cid, String cpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CPW FROM CUSTOMER WHERE CID = ? AND CPW = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			} else {
				result = FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 5. 정보수정
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPW = ?," + 
				"	                    CNAME = ?," + 
				"	                    CEMAIL = ?," + 
				"	                    CADDRESS = ?," + 
				"	                    CGENDER = ?," + 
				"	                    CBIRTH = ?" + 
				"	    WHERE CID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCemail());
			pstmt.setString(4, dto.getCaddress());
			pstmt.setString(5, dto.getCgender());
			pstmt.setDate(6, dto.getCbirth());
			pstmt.setString(7, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원수정성공":"회원수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 6. top-N 리스트
	public ArrayList<CustomerDto> listCustomer(int startRow, int endRow) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *" + 
				"	    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM CUSTOMER ORDER BY CRDATE DESC) A)" + 
				"	    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cid = rs.getString("cid");
				String cpw = rs.getString("cpw");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				String cgender = rs.getString("cgender");
				Date cbirth = rs.getDate("cbirth");
				Date crdate = rs.getDate("crdate");
				customers.add(new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return customers;
	}
	// 7. 회원수
	public int getCustomerCnt() {
		int customerCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM CUSTOMER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			customerCnt = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return customerCnt;
	}
}
