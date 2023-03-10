<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- requestScope.modifyBoard, param.bid, param.pageNum -->
	<form action="${conPath }/modify.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<%-- <input type="hidden" name="bid" value="${param.bid }"> --%>
		<input type="hidden" name="bid" value="${modifyBoard.bid }">
		<table>
			<caption>${param.bid }번글 수정하기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" value="${modifyBoard.bname }" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" value="${modifyBoard.btitle }" required="required"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" name="bcontent">${modifyBoard.bcontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" class="btn">
					<input type="reset" value="취소" class="btn" onclick="history.go(-1)">
					<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/list.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>