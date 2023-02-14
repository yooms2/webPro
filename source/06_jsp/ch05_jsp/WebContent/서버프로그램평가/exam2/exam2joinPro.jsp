<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			width:400px;
			height:600px;
			border:1px solid #A47160
		}
		h2:nth-child(1), hr {
			color:#A47160;
			text-align:center;
		}
	</style>
</head>
<body>
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwChk = request.getParameter("pwChk");
	String birth = request.getParameter("birth");
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
	response.setCharacterEncoding("utf-8");
	Date date = new Date();
%>
	<h2>회원가입정보</h2><hr>
	<h2>이름 : <%=name %></h2>
	<h2>아이디 : <%=id %></h2>
	<h2>비번 : <%=pw %></h2>
	<h2>생년월일 : <%=birth %></h2>
	<%for(int i=0 ; i<hobby.length ; i++) { %>
		<h2>취미 : <%=hobby[i] %></h2>
	<%} %>
	<h2>성별 : <%=gender %></h2>
	<h2>이메일 : <%=email %></h2>
	<%for(int i=0 ; i<mailSend.length ; i++) { %>
		<h2>메일수신동의 : <%=mailSend[i] %></h2>
	<%} %>
	<h2>가입일 : <%=date %></h2>
	<h2>가입IP : <%=request.getRemoteAddr() %></h2>
</body>
</html>