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
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
</head>
<body>
	<c:if test="${empty member }">
		<script>
			location.href='${conPath}/loginView.do';
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/boardReply.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="fgroup" value="${oriBoard.fgroup }">
			<input type="hidden" name="fstep" value="${oriBoard.fstep }">
			<input type="hidden" name="findent" value="${oriBoard.findent }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<caption>${oriBoard.fid }번 답변글 작성</caption>
				<tr><td>작성자</td><td>${member.mid }</td></tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="ftitle" required="required"
								value="[답]${oriBoard.ftitle }">
					</td>
				</tr>
				<tr><td>본문</td><td><textarea name="fContent" rows="3" cols="3"></textarea></td></tr>
				<tr><td>첨부파일</td><td><input type="file" name="ffilename"></td></tr>
				<tr><td colspan="2">
							<input type="submit" value="답변쓰기" class="btn">
							<input type="reset" value="취소" class="btn">
							<input type="button" value="목록" class="btn"
								onclick="location.href='${conPath}/boardList.do'">
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>