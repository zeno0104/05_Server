<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>/fr/rediect 요청 시 재요청 되어 보여지는 페이지</h3>
	<!-- 
		redirect해서 다른 servlet으로 요청을 하게된다면
		이전 request객체는 사라짐
		또한, 파라미터(전달된 데이터) 또한 사라진다.
		=> 이전 서블릿에서 끝났기 때문
	 -->
	<p>request scope로 전달된 값이 존재하는지 확인</p>
	<ul>
		<li>str2 : ${str2 }</li>
		<li>redirectInput1 : ${param.redirectInput1}</li>
		<li>redirectInput2 : ${param.redirectInput2}</li>
	</ul>
	<!-- 위 값들은 모두 소멸됌 -->

	<h3>session scope로 전달된 값 : ${sessionNum}</h3>
	
</body>
</html>