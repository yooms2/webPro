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
</head>
<body>
	<p>"현재 총 ${cnt }명"</p>
	<h3>결과는 다음과 같습니다</h3>
	<h4>이름 : ${student.name }</h4>
	<h4>국어 : ${student.kor }</h4>
	<h4>영어 : ${student.eng }</h4>
	<h4>수학 : ${student.mat }</h4>
	<h4>총점 : ${sum }</h4>
	<h4>평균 : ${avg }</h4>
	<button onclick="history.go(-1)">뒤로가기</button>
	<button onclick="location.href='${conPath}/'">다시입력</button>
</body>
</html>