<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">
			<form action="joinPro.jsp">
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="cid" id="cid" required="required" autofocus="autofocus"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="cpw" id="cpw" required="required"></td>
					</tr>
					<tr>
						<th>비밀번호확인</th>
						<td><input type="password" name="cpwChk" id="cpwChk" required="required"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="cname" id="cname" required="required"></td>
					</tr>
					<tr>
						<th>전화</th>
						<td><input type="password" name="ctel" id="ctel"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="cemail" id="cemail"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="caddress" id="caddress"></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="date" name="tempCbirth" id="cbirth"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<input type="radio" name="cgender" value="m" id="m">남자
							<input type="radio" name="cgender" value="f" id="f">여자
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="가입하기" class="joinBtn_style">
							<input type="reset" value="다시하기" class="joinBtn_style">
							<input type="button" value="로그인" class="joinBtn_style" onclick="location.href='<%=conPath %>/customer/loginForm.jsp'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>