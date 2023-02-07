<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		int i, j;
	%>
	<h2><%=su1 %>단부터 <%=su2 %>단까지</h2>
	<table>
		<tr>
			<%for(i=su1 ; i<=su2 ; i++) { %>
				<th><%=i %>단</th>
			<%} %>
		</tr>
			<%for(j=1 ; j<10 ; j++) { %>
				<tr>
					<%for(i=su1 ; i<=su2 ; i++) { %>
						<td><%=i + " * " + j + " = " + (i*j) %></td>
					<%} %>
				</tr>
			<%} %>
	</table>
</body>
</html>