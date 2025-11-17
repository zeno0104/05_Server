<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jsp에서는 full name으로 request를 적어서 사용해줘야함 -->
<title><%=request.getParameter("orderer")%>님의 주문결과</title>
</head>
<body>
	<div>
		<h1>
			주문자명 :
			<%=request.getParameter("orderer")%>
		</h1>
		<h3>
			주문한 커피 :
			<%-- "차가운 아메리카노", "따듯한 카푸치노" --%>
			<%
			if (request.getParameter("type").equals("ice")) {
			%>
			차가운
			<%
			} else {
			%>
			따뜻한
			<%
			}
			%>
			<%=request.getParameter("coffee")%>
		</h3>
		<%=request.getParameterValues("opt")%>

		<%
		if (request.getParameterValues("opt") != null) {
		%>
		<ul>
			<%
			for (String opt : request.getParameterValues("opt")) {
			%>
			<li><%= opt %></li>
			<%
			}
			%>
		</ul>
		<%
		}
		%>
	</div>
</body>
</html>