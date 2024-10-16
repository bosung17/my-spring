<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
</head>
<body>
	<form action="/login" method="POST">
		<!-- 4th : loginForm에 form 태그와 input 태그의 속성들이 헷갈림 -->
		ID : <input type="text" name="id"> 
		PW : <input type="password" name="pw">
		<button>로그인</button>
	</form>
</body>
</html>