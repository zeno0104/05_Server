<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- c : 자주 사용하는 Java 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- fn : 컬렉션/문자열 관련 기능 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과제</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

#bg {
	background-color: grey;
	color: grey;
	border-color: grey
}
</style>
</head>
<body>
	<h1>책 목록 조회</h1>
	<hr>
	<h3>전체 책 수량 : ${fn:length(bookList)}권</h3>
	<hr>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격(원)</th>
		</tr>

		<c:forEach var="book" items="${bookList}" varStatus="vs">
			<tr>
				<th id="num">${vs.count}</th>
				<td>${book.title}</td>
				<td>${book.writer}</td>
				<td>${book.price}</td>
			</tr>
			<c:if test="${vs.count % 3 == 0}">
				<tr id="bg">
					<td id="num" colspan='4'>${vs.count}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>