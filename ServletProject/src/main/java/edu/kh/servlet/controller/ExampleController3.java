package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderer = request.getParameter("orderer");
		String coffee = request.getParameter("coffee");
		String type = request.getParameter("type");

		String option = request.getParameter("opt");
		String[] optionArr = request.getParameterValues("opt");
		// request.getParameter("name속성값")
		// : 같은 name 속성을 가진 여러개 값 중 첫번째 값만 반환

		// req.getParameterValues("name 속성값")
		// : 같은 name 속성을 가진 모든 값을 배열로 반환

		System.out.println(orderer);
		System.out.println(coffee);
		System.out.println(type);
		System.out.println(option); // shot만 들어가있음
		System.out.println(optionArr); // 주소값
		
		// opt 미선택시 optionArr == null
		
		if(optionArr != null) {
			for(String opt : optionArr) {
				System.out.println(opt);
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/result2.jsp");
		dispatcher.forward(request, response);
		/*
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/WEB-INF/views/result2.jsp");
		 * dispatcher.forward(request, response);
		 */
	}
}
