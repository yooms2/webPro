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
	<c:if test="${not empty admin }">
		<script>
			alert('현재 관리자 모드 입니다');
			location.href='${conPath }/allView.do';
		</script>
	</c:if>
	<c:if test="${not empty member }">
		<script>
			alert('접근 제한 페이지 입니다');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<form action="${conPath }/adminLogin.do" method="post">
		<div id="content_form">
			<table>
				<caption>관리자 로그인</caption>
				<tr>
					<th>ID</th>
					<td><input type="text" name="aid" required="required"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="apw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" class="btn">
					</td>
				</tr>
			</table>
		</div>
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>