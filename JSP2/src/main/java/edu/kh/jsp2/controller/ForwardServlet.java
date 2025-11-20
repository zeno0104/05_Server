package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fr/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request scope
		request.setAttribute("str", "안녕하세요"); // str=안녕하세요
		
		// 요청발송자 이용해서 request, response를 forward_result.jsp 위임
		request.getRequestDispatcher("/WEB-INF/views/fr/forward_result.jsp").forward(request, response);
	}

}
