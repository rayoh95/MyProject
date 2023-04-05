<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>
	<%@ include file="../default/header.jsp" %>
	<br><br>
	<div class="content" align="center">
		<h1>전체 게시글 목록</h1>
		<table style="width: 700px"border="1">
			<tr>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<tr>
			<c:forEach var="boardDto" items="${boardList }">
				<tr align="center">
					<td><a href="${contextPath }/board/info?num=${boardDto.num }">${boardDto.title }</a></td>
					<td>${boardDto.writer }</td>
					<td><fmt:formatDate value="${boardDto.regDate }" pattern="yyyy-MM-dd"/></td>
					<td>${boardDto.readCount }</td>
				</tr>
			</c:forEach>
			</tr>
			<tr>
				<td colspan="5" align="right"><input type="button" value="글쓰기" onclick="location.href='${contextPath }/board/write'"/></td>
			</tr>
		</table>
	</div>
</body>
</html>