<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%-- <h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P> --%>

<script>
	setTimeout(function(){ window.location.replace('${contextPath}/member/login')}, 100);
</script>
</body>
</html>
