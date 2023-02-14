<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%! String suParam; int su; %>
	<%
		suParam =request.getParameter("su");
		if(suParam!=null) {
			su = Integer.parseInt(suParam);
			int comSu = (int)(Math.random()*3)+1;
			if(su!=comSu) {
				String msg = "<h2>Wrong! Try Again!</h2>" + "<h2>(" + su + "은(는 ) 아니고 정답은 " + comSu + ")</h2>";
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect("exam.jsp?msg=" + msg);
			}
		} else {
			response.sendRedirect("exam.jsp");
		}
	%>
	<div>
		<h2>정답입니다</h2>
		<h2>동전이 있던 곳은 <%=su %></h2>
		<button onclick="location.href='exam.jsp'">다시 도전</button>
	</div>
</body>
</html>