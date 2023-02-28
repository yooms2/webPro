<%@page import="java.sql.Date"%>
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
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempCbirth = request.getParameter("tempCbirth");
		if(!tempCbirth.equals("")) {
			dto.setCbirth(Date.valueOf(tempCbirth));
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.confirmId(dto.getCid());
		if(result == CustomerDao.CUSTOMER_NONEXIST) {
			result = cDao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS) {
				session.setAttribute("cid", dto.getCid());
	%>
				<script>
					alert('회원가입 감사합니다');
					location.href = '<%=conPath %>/customer/loginForm.jsp';
				</script>
		<%} else { %>
				<script>
					alert('회원가입에 실패하였습니다(길이제한)');
					history.back();
				</script>
		<%} %>
	<%} else { %>
		<script>
			alert('중복된 ID입니다');
			history.back();
		</script>
	<%} %>
</body>
</html>