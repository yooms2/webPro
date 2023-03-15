<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	$(function() {
		$('input[name="mid"]').keyup(function() {
			var mid = $(this).val();
			if(mid.length < 4) {
				$('#midConfirmResult').text('아이디는 4글자 이상 입력 시 가입이 가능합니다');
			} else {
				$.ajax({
					url : '${conPath }/idConfirm.do',
					type : 'get',
					data : 'mid='+mid,
					dataType : 'html',
					success : function(data) {
						$('#midConfirmResult').html(data);
					},
				});
			}
		});
		
		$('input[name="mpw"], input[name="mpwChk"]').keyup(function() {
			var mpw = $('input[name="mpw"]').val();
			var mpwChk = $('input[name="mpwChk"]').val();
			if(mpw == mpwChk) {
				$('#mpwChkResult').text('비밀번호 일치');
			} else {
				$('#mpwChkResult').text('비밀번호 불일치');
			}
		});
		
		var pattern = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;
		/* $('input[name="memail"]').keyup(function() {
			var memail = $(this).val();
			if(!memail.match(pattern)) {
				$('#memailConfirmResult').text('올바른 이메일을 입력해주세요');
			} else {
				$.ajax({
					url : '${conPath }/emailConfirm.do',
					type : 'get',
					data : 'memail='+memail,
					dataType : 'html',
					success : function(data) {
						$('#memailConfirmResult').html(data);
					}
				});
			}
		}); */
		
		$('form').submit(function() {
			var midConfirmResult = $('#midConfirmResult').text();
			var mpwChkResult = $('#mpwChkResult').text();
			if(midConfirmResult != '사용 가능한 ID입니다') {
				alert('사용 가능한 ID가 아닙니다');
				return false;
			} else if(mpwChkResult != '비밀번호 일치') {
				alert('비밀번호가 맞지 않습니다');
				$('#pw').focus();
				return false;
			}
		});
		
		$("#datepicker").datepicker({
			dateFormat: "yy-mm-dd",
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ],
			changeMonth: true, // 월을 바꿀 수 있는 셀렉트 박스를 표시한다.
			changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
			showMonthAfterYear: true,
			yearSuffix: '년',
			showOtherMonths: true,
			minDate: new Date(1950, 1 - 1, 1), // 1950년 1월 1일을 최소 날짜로 세팅
	    	maxDate: 'y', // 현재 날짜 이전만 선택 가능
	    	yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		});
	});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
		<div id="content_form">
		<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
			<table>
				<caption>회원가입</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="mid" placeholder="4글자 이상" required="required">
						<div id="midConfirmResult"></div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw" required="required"></td>
				</tr>
				<tr>
					<th>비밀번호확인</th>
					<td>
						<input type="password" name="mpwChk" required="required">
						<div id="mpwChkResult"></div>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" required="required"></td>
				</tr>
				<tr>
					<th>메일</th>
					<td>
						<input type="text" name="memail" placeholder="이메일 형식으로 입력해주세요">
						<div id="memailConfirmResult"></div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="mphoto"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="mbirth" id="datepicker"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="maddress"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입" class="btn">
						<input type="button" value="로그인" class="btn" onclick="location.href='${conPath }/loginView.do'">
					</td>
				</tr>
			</table>
		</form>
		</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>