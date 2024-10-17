<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	${fileName}
	<a href="/img/${fileName}">${fileName}</a>
	<img src="/img/${fileName}">
	
	<!-- 2nd try : href 속성을 작성할 때 query string 작성이 헷갈림 -->
	<a href="/download?fileName=${fileName}">이미지다운로드</a>
</body>
</html>