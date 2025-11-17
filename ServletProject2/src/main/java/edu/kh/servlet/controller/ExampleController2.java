package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet 관련 코드를 작성하기 위해서는 HttpServlet 클래스 상속 받아야함 
// 상속받았다고해서 바로 Servlet 등록이 되는것은 아님!
// -> 방법1. web.xml 작성하기
//    방법2. @WebServlet() 어노테이션 사용하기

@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputId = request.getParameter("inputId");
		String inputPw = request.getParameter("inputPw");
		String inputName = request.getParameter("inputName");
		String intro = request.getParameter("intro");
		
		PrintWriter out = response.getWriter();
		
		out.println("inputId : " + inputId + " inputPw : " + inputPw + " inputName : " + inputName + " intro : " + intro);
	}
}
