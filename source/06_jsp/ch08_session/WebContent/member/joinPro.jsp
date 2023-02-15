<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
</head>
<body>
<%	
	request.setCharacterEncoding("utf-8");
	String hiddenParam = request.getParameter("hiddenParam");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String birth = request.getParameter("birth");
	String[] hobby = request.getParameterValues("hobby");
	String gender = (String)session.getAttribute("gender");
	String email = (String)session.getAttribute("email");
	String[] mailSend = request.getParameterValues("mailSend");
	/* String hiddenParam = (String)session.getAttribute("hiddenParam");
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	String birth = (String)session.getAttribute("birth");
	String[] hobby = (String[])session.getAttribute("hobby");
	String gender = (String)session.getAttribute("gender");
	String email = (String)session.getAttribute("email");
	String[] mailSend = (String[])session.getAttribute("mailSend"); */
	session.setAttribute("id", id);
%>
	<jsp:include page="../member/header.jsp"/>
	<div id="joinForm_wrap">
	<div id="join_title">회원가입정보</div>
		<h3>hiddenParam <%=hiddenParam %></h3>
		<h3>name : <%=name %></h3>
		<h3>id : <%=id %></h3>
		<h3>pw : <%=pw%>
		<h3>birth3 : <%=birth %></h3>
		<h3>hobby : <% 
				if(hobby!=null) {
					for(int i=0 ; i<hobby.length ; i++)
						if(i==hobby.length-1)
							out.print(hobby[i]);
						else
							out.print(hobby[i]+", ");
				}else {
					out.print("없음");
				}
		%></h3>
		<h3>gender : <%=gender %></h3>
		<h3>email : <%=email %></h3>
		<h3>mailSend : <%
				if(mailSend!=null){
					out.print(Arrays.toString(mailSend));
				}else{
					out.print("모두 수신 거부");
				}
		%>
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>