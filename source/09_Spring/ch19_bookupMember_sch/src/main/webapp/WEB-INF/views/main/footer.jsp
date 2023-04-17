<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<style>
		footer {
			height:60px; background-color: #003300;
	 	}
		footer #footer_conts {
			color:white;
			font-weight: blod;
			margin:0 auto;
			height: 60px;
			padding:10px 30px 0;
			font-size:0.9em;
			text-align: center;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<footer>
		<div id="footer_conts">
			(주)IT 402 | 전화 : 02-123-1234 | 팩스 : 070-1234-1234 | 메일 : help@lec.com 
			<br>
			서울특별시 OO구 XX동 **빌딩 4층
		</div>
	</footer>
</body>
</html>