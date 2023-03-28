<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${contextPath}/resources/jquery/jquery-3.5.1.min.js"></script>
<title>info</title>
</head>
<body>
	<div align="center">
		<img src="${contextPath }/member/profile?fileName=${memberDto.profileImage }" /><br>
		${memberDto.memberId }<br>
		${year - memberDto.memberBirthY + 1 }<br>
		${memberDto.memberHeight }<br>
		${memberDto.roadAddress } ${memberDto.remainAddress }<br>
	</div>
</body>
</html>