<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			background-color: lightyellow;
		}
		#Join_form {
			height: 630px;
			line-height: 630px;
			font-size: 42px;
			text-align: center;
			width: 800px;
			margin: 0px auto;
			border: 1px solid green;
			color: darkgreen;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<jsp:include page="../customer/header.jsp"/>
	<div id="Join_form">
		main 화면
	</div>
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>