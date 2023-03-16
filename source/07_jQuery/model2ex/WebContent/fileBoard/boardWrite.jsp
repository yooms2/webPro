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
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty member }">
		<script>
			location.href="${conPath }/loginView.do?pageNum=${pageNum }";
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
		<div id="content_form">
			<form action="${conPath }/boardWrite.do" method="post" enctype="multipart/form-data">
				<table>
					<caption>글쓰기</caption>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="mid" value="${member.mid }" readonly="readonly"></td>
					</tr>
					<tr>
						<th>글제목</th>
						<td><input type="text" name="ftitle" required="required"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="5" cols="5" name="fcontent"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="ffilename"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="글쓰기" class="btn">
							<input type="reset" value="다시쓰기" class="btn">
							<input type="button" value="목록" class="btn" onclick="history.back()">
						</td>
					</tr>
				</table>
			</form>
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>