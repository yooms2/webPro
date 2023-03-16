<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
			<caption>${contentBoard.fid }글 상세보기</caption>
			<tr>
				<th>작성자</th>
				<td>${contentBoard.mid }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${contentBoard.ftitle }</td>
			</tr>
			<tr>
				<th>본문</th>
				<td><pre>${contentBoard.fcontent }</pre></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:if test="${not empty contentBoard.ffilename }">
						${contentBoard.ffilename }
					</c:if>
					<c:if test="${empty contentBoard.ffilename }">
						첨부파일없음
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${member.mid eq contentBoard.mid }">
						<button onclick="location.href='${conPath }/boardModifyView.do?fid=${contentBoard.fid }&pageNum=${param.pageNum }'">수정</button>
					</c:if>
					<c:if test="${member.mid eq contentBoard.mid }">
						<button onclick="location.href='${conPath }/boardDelete.do?fgroup=${contentBoard.fgroup }&fstep=${contentBoard.fstep }&findent=${contentBoard.findent }&pageNum=${param.pageNum }'">삭제</button>
					</c:if>
					<c:if test="${not empty member }">
						<button onclick="location.href='${conPath}/boardReplyView.do?fid=${contentBoard.fid }&pageNum=${param.pageNum }'">답변</button>
					</c:if>
					<button onclick="location.href='${conPath }/boardList.do?pageNum=${param.pageNum }'">목록</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>