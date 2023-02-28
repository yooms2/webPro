<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		String method = request.getParameter("method");
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.loginCustomer(cid, cpw);
		if(result==CustomerDao.FAIL) {
			response.sendRedirect(conPath + "/customer/loginForm.jsp?msg=");
		} else {
			CustomerDto customer = cDao.getCustomer(cid);
			session.setAttribute("customer", customer);
			if(method.equals("null")) {
				response.sendRedirect(conPath + "/main/main.jsp");
			} else {
				response.sendRedirect(conPath + "/customer/" + method + ".jsp");
			}
		}
	%>
</body>
</html>