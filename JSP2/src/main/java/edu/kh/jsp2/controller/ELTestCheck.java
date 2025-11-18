package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el/check")
public class ELTestCheck extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getAttribute("requestValue"));
		// request scope 객체에 세팅한 값
		// 즉, request는 요청받은 서블릿과 요청이 위임된 JSP까지만 유효하다는 증거

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/el/check.jsp");
		dispatcher.forward(request, response);
	}
}
