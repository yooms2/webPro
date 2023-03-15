<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty joinResult }">
		alert('${joinResult }');
	</c:if>
	<jsp:include page="../main/header.jsp"/>
		<div id="content_form">
			<form action="${conPath }/login.do" method="post">
				<table>
					<tr>
						<th>ID</th>
						<td><input type="text" name="mid" value="${mid }" required="required"></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="password" name="mpw" required="required"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인">
							<input type="button" value="회원가입" onclick="location.href='${conPath }/joinView.do'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>