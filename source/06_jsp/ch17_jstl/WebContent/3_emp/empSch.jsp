<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="">
		이름 <input type="text" name="schName" value="${param.schName.toUpperCase().trim() }" class="btn">
		직책 <input type="text" name="schJob" value="${fn:toUpperCase(fn:trim(param.schJob)) }" class="btn">
		<input type="submit" value="검색" class="btn">
	</form>
	<br>
	<table>
		<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서</th></tr>
		<c:if test="${emp.size() eq 0 }">
			<tr><td colspan="8">해당되는 사원이 없습니다</td></tr>
		</c:if>
		<c:if test="${emp.size() != 0 }">
			<c:forEach var="emp" items="${emps }">
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td>${emp.hiredate }</td>
					<td>${emp.sal }</td>
					<td>${emp.comm }</td>
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>