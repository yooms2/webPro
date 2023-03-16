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
			$('tr').click(function() {
				var fid = $(this).children().eq(0).text().trim();
				if(!isNaN(fid)) {
					location.href="${conPath }/boardContent.do?fid="+fid+"&pageNum=${pageNum }";
				}
			});
		});
	</script>
	<style>
		#content_form {
			margin-bottom: 100px;
		}
	</style>
</head>
<body>
	<c:if test="${not empty boardResult }">
		<script>
			alert('${boardResult}');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
		<div id="content_form">
			<table>
				<tr>
					<td>
						<c:if test="${empty member }">
							<a href="${conPath }/loginView.do">
								글쓰기는 사용자 로그인 이후에만 가능합니다
							</a>
						</c:if>
						<c:if test="${not empty member }">
							<a href="${conPath }/boardWirteView.do">
								글쓰기
							</a>
						</c:if>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th><th>날짜</th><th>IP</th>
				</tr>
				<br>
				<c:if test="${boardList.size() eq 0 }">
					<tr>
						<td colspan="6">
							해당 페이지의 글이 없습니다
						</td>
					</tr>
				</c:if>
				<c:if test="${boardList.size() != 0 }">
					<c:forEach var="dto" items="${boardList }">
						<tr>
							<td>${dto.fid }</td>
							<td>${dto.mid }</td>
							<td class="left">
								<c:forEach var="i" begin="1" end="${dto.findent }">
									<c:if test="${i != dto.findent }">
										&nbsp; &nbsp; &nbsp;
									</c:if>
									<c:if test="${i eq dto.findent }">
										└
									</c:if>
								</c:forEach>
								${dto.ftitle }
							</td>
							<td>
								<c:if test="${dto.fhit > 10 }">
									<b>(인기글)</b>
								</c:if>
								${dto.fhit }
							</td>
							<td>
								<fmt:formatDate value="${dto.frdate }" pattern="yy.MM.dd"/>
								${dto.frdate }
							</td>
							<td>${dto.fip }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<div class="paging">
				<c:if test="${BLOCKSIZE < startPage }">
					<a href="${conPath }/boardList.do?pageNum=${startPage-1 }"> 이전 </a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<c:if test="${i eq pageNum }">
						[ <b> ${i } </b> ]
					</c:if>
					<c:if test="${i != pageNum }">
						[ <a href="${conPath }/boardList.do?pageNum=${i }"> ${i } </a> ]
					</c:if>
				</c:forEach>
				<c:if test="${endPage < pageCnt }">
					<a href="${conPath }/boardList.do?pageNum=${endPage+1 }"> 다음 </a>
				</c:if>
			</div>
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>