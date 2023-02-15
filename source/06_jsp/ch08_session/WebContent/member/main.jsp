<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#Join_form {
			height: 630px;
			line-height: 630px;
			font-size: 32px;
			text-align: center;
			width: 800px;
			margin: 0px auto;
			border: 1px solid #805040;
			color: #805040;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<div id="Join_form">
		main 화면
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>