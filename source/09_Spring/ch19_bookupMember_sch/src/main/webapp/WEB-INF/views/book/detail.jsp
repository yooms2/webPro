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
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
		img{width: 100px;}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption>${bookDto.bnum }번 도서 상세보기</caption>
			<tr><th>책이름</th><td colspan="2">${bookDto.btitle }</td></tr>
			<tr><th>저자</th><td colspan="2">${bookDto.bwriter }</td></tr>
			<tr><th>출판일</th><td colspan="2">${bookDto.brdate }</td></tr>
			<tr><th>책이미지</th><td><img src="${conPath }/bookImgFileUpload/${bookDto.bimg1 }"></td>
								<td><img src="${conPath }/bookImgFileUpload/${bookDto.bimg2 }"></td></tr>
			<tr><th>책소개</th><td colspan="2">${bookDto.binfo }</td></tr>
			<tr><td colspan="3">
				<button onclick="location='book.do?method=modify&bnum=${bookDto.bnum}&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location='book.do?method=list&pageNum=${param.pageNum}'">목록</button>
			</td></tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>