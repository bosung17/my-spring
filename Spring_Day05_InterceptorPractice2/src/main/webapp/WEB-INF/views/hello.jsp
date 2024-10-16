<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h2>메인 화면</h2>
	<c:if test="${empty loginUser}">
	<a href="/login">로그인</a>
	</c:if>
	<c:if test="${not empty loginUser}">
	<span>${loginUser}님 반갑습니다.</span>
	<a href="/regist">등록페이지로</a>
	<a href="/logout">로그아웃</a>
	</c:if>
</body>
</html>