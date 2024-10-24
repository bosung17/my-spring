<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<%@ include file="../common/bootstrap.jsp"%>
</head>
<body>
	<!-- 부트스트랩 쓸 거면 div에 container 해주기 -->
	<div class="container">
		<h2>게시글 목록</h2>
		<hr>
		<table class="table text-center">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.id}</td>
					<td><a href="detail?id=${board.id}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.viewCnt}</td>
					<td>${board.regDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-end">
			<a class="btn btn-outline-primary" href="/writeform">글등록</a>
		</div>
	</div>
</body>
</html>