<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
	<script>
		window.onload = function(){
			document.querySelector('form').onsubmit = function(){
				var pw = document.getElementById('cpw');
				var pwChk = document.getElementById('cpwChk');
				var patternMail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/; // macth함수 사용
				var email = document.getElementById('cemail');
				if(pw.value != pwChk.value){
					alert('비밀번호를 확인하세요');
					pw.value = '';
					pwChk.value = '';
					pw.focus();
					return false;
				}else if(email.value && !email.value.match(patternMail)){
			      alert('메일 형식을 확인하세요');
			      email.focus();
		     	 return false;
				}
			};
		};
	</script>
</head>
<body>
<%!
	String cid, cname, ctel, cemail, caddress, cgender;
	Date cbirth;
%>
<%
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	if(customer==null) {
		response.sendRedirect("login.jsp?method=modify");
	} else {
		cid = customer.getCid();
		cname = customer.getCpw();
		ctel = customer.getCtel();
		cemail = customer.getCemail();
		caddress = customer.getCaddress();
		cgender = customer.getCgender();
		cbirth = customer.getCbirth();
	}
%>
	<jsp:include page="../customer/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">정보수정</div>
		<form action="<%=conPath %>/customer/modifyPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" class="cid" value="<%=cid %>" required="required"></td>
				</tr>
				<tr>
					<th><label for="oldPW">현비밀번호</label></th>
					<td><input type="password" name="oldCpw" id="oldCpw" class="cpw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpw">새비밀번호확인</label></th>
					<td><input type="password" name="cpw" id="cpw" class="cpw"></td>
				</tr>
				<tr>
					<th><label for="cpw">새비밀번호확인</label></th>
					<td><input type="password" name="cpwChk" id="cpwChk" class="cpwChk"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname" class="cname" value="<%=cname %>" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td><input type="text" name="ctel" id="ctel" class="ctel" value='<%=ctel==null? "": ctel %>'></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="text" name="cemail" id="cemail" class="cemail" value='<%=cemail==null? "" : cemail %>'></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" class="caddress" value='<%=caddress==null? "" : caddress%>'></td>
				</tr>
				<tr>
					<th><label for="cbirth">생년월일</label></th>
					<td>
						<input type="date" name="tempCbirth" id="cbirth" class="cbirth" value='<%=cbirth==null? "":cbirth.toString() %>'>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<%if("m".equals(cgender)) { %>
							<input type="radio" name="cgender" value="m" checked="checked" id="m"><label for="m">남</label>
							<input type="radio" name="cgender" value="f" id="f"><label for="f">여</label>
						<%}else if("f".equals(cgender)) { %>
							<input type="radio" name="cgender" value="m" id="m"><label for="m">남</label>
							<input type="radio" name="cgender" value="f" checked="checked" id="f"><label for="f">여</label>
						<%}else { %>
							<input type="radio" name="cgender" value="m" id="m"><label for="m">남</label>
							<input type="radio" name="cgender" value="f" id="f"><label for="f">여</label>
						<%} %>
					</td>
				</tr>
				<tr>
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="이전으로" class="joinBtn_style" onclick="history.back();">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>