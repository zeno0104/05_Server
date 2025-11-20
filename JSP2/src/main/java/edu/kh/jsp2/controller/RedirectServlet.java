package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fr/redirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request scope 속성 추가
		request.setAttribute("str2", "request scope에 세팅된 값");
		
		// session scope 속성 추가
		HttpSession session = request.getSession();
		session.setAttribute("sessionNum", 10000);
		
		
		// 재요청 (위임이 아닌 재요청, 다른 서블릿에게 요청하는 것)

		// response.sendRedirect("다시 요청할 서블릿의 매핑주소");
		// -> 파일경로가 아님!
		// -> 다시 요청할 Servlet의 @WebServlet(주소)에서 주소를 적기!!!
		// *** 재요청(redirect)은 무조건 GET 방식임 ***

		// response.sendRedirect("다시 요청할 Servlet 주소");

		// redirect할 경우, 즉 로그인같은 경우는 session에 데이터를 저장
		response.sendRedirect("/fr/result");
	}
}
