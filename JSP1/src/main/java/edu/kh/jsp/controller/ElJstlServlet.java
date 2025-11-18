package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el_jstl")
// ** 주소 작성 시 반드시 맨 앞에 "/"로 시작해야함 **
public class ElJstlServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) JSP 경로 (webapp 폴더 기준)
		String path = "/WEB-INF/views/el_jstl.jsp";

		// 2) 요청 발송자 얻어오기
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		// 3) 요청 위임 (forward)
		dispatcher.forward(request, response);
	}
}
