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
<script src="${contextPath }/resources/jquery/jquery-3.5.1.min.js"></script>
<script>
	function readURL(input){
		var file = input.files[0]	
		if(file != ''){
			var reader = new FileReader();	
			reader.readAsDataURL(file);		
			reader.onload = function(e){
				document.getElementById("preview").src = e.target.result
			}
		}
	}
</script>
</head>
<body>
	<div align="center" style="padding-top: 50px">
		<form action="${contextPath }/board/update?num=${boardDto.num }" enctype="multipart/form-data" method="post" >
			<!-- <input type="hidden" name="num" value=${boardDto.num }/> -->
			<div align="center">
				<h1>게시글 수정</h1>
				<br>
			</div>
			<table style="width: 700px;" border="1">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${boardDto.title }"/></td>
				</tr>
				<tr>
				<tr>
					<td colspan="2">
						<img src="${contextPath }/board/image?fileName=${boardDto.image }" id="preview" width="150px" height="150px">
						<input type="file" onchange="readURL(this)" name="file">
					</td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><textarea rows="10" cols="60" name="content">${boardDto.content }</textarea></td>
				</tr>
				<tr align="center">
					<td colspan="4">
						<input type="submit" value="글수정" />
						<input type="button" value="전체글보기" onclick="location.href='${contextPath }/board/boardList'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>