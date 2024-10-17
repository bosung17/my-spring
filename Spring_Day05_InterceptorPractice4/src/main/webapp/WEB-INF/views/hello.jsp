<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<h2>Hello</h2>
	<c:if test="${empty loginUser}">
		<a href="/login">로그인</a>
	</c:if>
	<c:if test="${not empty loginUser}">
		<span>${loginUser}님 반갑습니다.</span>
		<a href="/regist">to regist</a>
		<a href="/logout">로그아웃</a>
	</c:if>
</body>
</html>