<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#logoutForm_wrap{
			height:600px; line-height: 600px; font-size: 32px;
			text-align: center;
			width:1000px;            	
			margin:0px auto; 
		}
	</style>
	<script>
		setTimeout(function() {
			location.href='<%=conPath %>';
		}, 2000);
	</script>
</head>
<body>
	<%
		String msg = "";
		if(session.getAttribute("customer")!=null) {
			session.invalidate();
			msg = "<h4>로그아웃 되었습니다. 메인페이지로 이동합니다</h4>";
		} else {
			msg = "<h4>로그인 상태가 아닙니다. 메인페이지로 이동합니다</h4>";
		}
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="logoutForm_wrap">
		<%=msg %>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>