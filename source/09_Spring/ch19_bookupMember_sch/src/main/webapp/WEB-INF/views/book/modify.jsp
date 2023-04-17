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
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<style>
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
	</style>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="${conPath }/book.do" method="post"  enctype="multipart/form-data">
			<input type="hidden" name="method" value="modify">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="bnum" value="${bookDto.bnum }">
			<table>
				<caption>${bookDto.bnum }번 도서 수정하기</caption>
				<tr><th>책이름</th><td><input type="text" name="btitle" value="${bookDto.btitle }"></td></tr>
				<tr><th>저자</th><td><input type="text" name="bwriter" value="${bookDto.bwriter }"></td></tr>
				<tr><th>출판일</th><td><input type="date" name="brdate"  id="datepicker" value="${bookDto.brdate }"></td></tr>
				<tr><th>책이미지1</th><td><input type="file" name="tempBimg1">${bookDto.bimg1 }</td></tr>
				<tr><th>책이미지2</th><td><input type="file" name="tempBimg2">${bookDto.bimg2 }</td></tr>
				<tr><th>책소개</th><td><textarea rows="5" cols="20" name="binfo">${bookDto.binfo}</textarea></td></tr>
				<tr><td colspan="2">
					<input type="submit" value="저장">
					<input type="button" value="목록" onclick="location='book.do?method=list&pageNum=${param.pageNum}'">
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>