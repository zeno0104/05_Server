<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>page : ${pageValue}</h3>
	<h3>request : ${requestValue}</h3>
	<h3>session : ${sessionValue}</h3>
	<h3>application : ${applicationValue}</h3>
	
	<a href="/el/check">객체 범위 확인페이지로 이동</a>
	
	<hr>
	
	<h1>범위별 객체 우선순위 확인</h1>
	<%
		pageContext.setAttribute("menu", "짬짜면(page)");
	%>
	<h4>우선순위 menu 출력 ${menu}</h4>
	
	<h3>원하는 scope의 menu로 세팅된 값 출력</h3>
	<p>${pageScope.menu}</p>
	<p>${requestScope.menu}</p>
	<p>${sessionScope.menu}</p>
	<p>${applicationScope.menu}</p>
</body>
</html>