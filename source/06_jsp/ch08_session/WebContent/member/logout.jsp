<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#logout_form {
			height: 630px;
			line-height: 630px;
			font-size: 25px;
			text-align: center;
			width: 800px;
			margin: 0px auto;
			border: 1px solid #805040;
			color: #805040;
			font-weight: bold;
		}
	</style>
	<script>
		setTimeout(function() {
			location.href='main.jsp'
		}, 3000);
	</script>
</head>
<body>
	<%
		session.invalidate();
	%>
	<jsp:include page="../member/header.jsp"/>
	<div id="logout_form">
		로그아웃 되었습니다. 잠시 후 페이지 이동이 있겠습니다
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>