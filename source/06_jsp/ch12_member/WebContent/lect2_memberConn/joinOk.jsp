<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth"); // ""이거나 "1995-12-12"
		if(!tempBirth.equals("")) {
			dto.setBirth(Date.valueOf(tempBirth));
			// dto의 birth가 Timstamp형이면 : dto.setBirth(Timestamp.valueOf(tempBirth+" 00:00:00"));
		}
		MemberDaoConn mDao = new MemberDaoConn();
		int result = mDao.confirmId(dto.getId()); // ID 중복체크
		if(result == MemberDaoConn.MEMBER_NONEXISTENT) {
			// 사용가능한 ID라서 회원가입 진행
			result = mDao.joinMember(dto); // 회원가입
			if(result == MemberDaoConn.SUCCESS) {
				// 회원가입 성공
				session.setAttribute("id", dto.getId());
	%>
		<script>
			alert('회원가입 감사합니다');
			location.href = 'login.jsp';
		</script>
	<%		} else { // 회원가입 실패 %>
		<script>
			alert('회원가입이 실패되었습니다. 길이 제한이 있습니다');
			// hitory.back();
			location.href = 'join.jsp';
		</script>
	<%} %>
	<%} else { // 중복된 ID라서 join.jsp로 %>
		<script>
			alert('중복된 ID입니다. 다른 아이디를 사용하세요');
			history.back();
		</script>
	<%} %>
</body>
</html>