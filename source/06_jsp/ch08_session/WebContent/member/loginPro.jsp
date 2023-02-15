<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id!=null && id.equals("aaa")) {
			if(pw!=null && pw.equals("111")) {
				session.setAttribute("id", id);
				session.setAttribute("name", "홍길동");
				response.sendRedirect("main.jsp");
				
			}
		}
		
	%>
	<%-- <jsp:include page="../member/header.jsp"/>
	<br><br><br><br><br><br>
	<div id="loginForm_wrap">
		<div id="login_title">로그인 결과</div>
		<div id="login_join">로그인  성공</div>
	</div>
	<br><br><br><br><br><br>
	<jsp:include page="footer.jsp"/> --%>
</body>
</html>