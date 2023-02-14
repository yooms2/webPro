<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="exam2join.css" rel="stylesheet">
</head>
<body>
	<form action="exam2joinPro.jsp" method="post">
		<div id="joinForm_wrap">
			<div id="join_title">
				<p>회원가입</p>
			</div>
			<hr>
			<table>
				<tr>
					<td>이름</td>
					<td class="name"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td class="id"><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td class="pw"><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td class="pwChk"><input type="password" name="pwChk"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td class="birth"><input type="date" name="birth"></td>
				</tr>
				<tr>
					<td>취미</td>
					<td>
						<input type="checkbox" name="hobby" value="독서">독서
						<input type="checkbox" name="hobby" value="요리">요리
						<input type="checkbox" name="hobby" value="운동">운동
						<input type="checkbox" name="hobby" value="취침">취침
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="gender" value="남자">남자
						<input type="radio" name="gender" value="여자">여자
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td class="email"><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>메일수신</td>
					<td class="mailSend">
						<select multiple="multiple" size="3" name="mailSend">
							<option>광고</option>
							<option>배송</option>
							<option>공지</option>
							<option>업무</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기">
						<input type="reset" value="다시하기">
						<input type="button" value="뒤로가기">
					</td>
				</tr>
			</table>
		</div>
	</form>
	<%@ include file="exam2footer.jsp" %>
</body>
</html>