<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		header {
			width: 800px;
			margin: 0 auto;
		}
		header ul {
			overflow: hidden;
		}
		header ul li {
			list-style: none;
			float: right;
			padding: 10px 30px;
		}
		header ul li a {
			text-decoration: none;
			font-weight: bold;
			font-size: 1.5em;
			color: #805040;
		}
	</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
				String name = (String)session.getAttribute("name");
			%>
			<%if(name == null) { // 로그인 전 헤더 화면 %>
				<ul>
					<li><a href="<%=conPath %>/member/join.jsp">회원가입</a></li>
					<li><a href="<%=conPath %>/member/login.jsp">로그인</a></li>
					<li><a href="#">홈</a></li>
				</ul>
			<%} else { // 로그인 후 헤더 화면%>
				<ul>
					<li><a href="<%=conPath %>/member/logout.jsp">로그아웃</a></li>
					<li><a href="<%=conPath %>/member/joinPro.jsp">정보수정</a></li>
					<li><a href="#"><%=name %>님</a></li>
				</ul>
			<%} %>
		</div>
	</header>
</body>
</html>