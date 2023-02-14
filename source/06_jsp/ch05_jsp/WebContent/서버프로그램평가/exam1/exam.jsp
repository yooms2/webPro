<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			width: 300px;
			height: 300px;
			border: 2px solid skyblue;
		}
		hr {
			margin-bottom: 50px;
			color: skyblue;
		}
		table {
			width: 300px;
		}
		td {
			text-align: center;
		}
		#msg {
			text-align: center
			color: red;
		}
	</style>
	<script>
		function position(n) {
			location.href = 'examPro.jsp?su='+n;
		}
	</script>
</head>
<body>
	<div id="msg">
		<button onclick="position(1)">1번</button>
		<button onclick="position(2)">2번</button>
		<button onclick="position(3)">3번</button>
		<%
			String msg = request.getParameter("msg");
			if(msg!=null) {
				out.print(msg);
			}
		%>
	</div>
</body>
</html>