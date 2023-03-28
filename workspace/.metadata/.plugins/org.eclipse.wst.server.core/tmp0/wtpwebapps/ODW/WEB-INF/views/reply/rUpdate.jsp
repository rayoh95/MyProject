<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<div align="center">
		<form action="${contextPath }/reply/update?num=${replyDto.num }&bNum=${replyDto.bNum }" method="post" >
			<p><textarea rows="2" cols="100" name="content">${replyDto.content }</textarea></p>
			<input type="submit" value="수정" />
		</form>
	</div>
</body>
</html>