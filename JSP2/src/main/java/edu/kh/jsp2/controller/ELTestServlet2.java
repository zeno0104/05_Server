package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/el/scope")
public class ELTestServlet2 extends HttpServlet {
	// a태그 요청은 GET 방식 -> doGet() 오버라이딩
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 처리

		// 1. page scope -> 해당 JSP 파일에서만 확인 가능
		// (서블릿 클래스에서는 불가능, 딱 1페이지만 유효)

		// 2. request scope
		// - 요청 받은 Servlet과 요청이 위임된 JSP까지 유지되는 객체

		// 1) 객체에 값(속성) 추가하는 방법
		// 범위객체.getAttribute("key");
		request.setAttribute("requestValue", "request scope 객체에 세팅한 값");

		// 범위객체에 세팅한 값(속성) 형태
		// Key = Value
		// requestValue = request scope 객체에 세팅한 값

		// 2) 객체에서 값(속성) 얻어오는 방법
		// 범위객체.getAttribute("key");

		// 3. session scope
		// - 클라이언트가 서버에 첫 요청 시 서버쪽에 생성되는 객체
		// - 클라이언트가 브라우저를 종료하거나 지정된 세션 만료 시간이 지나면 사라짐
		// -> 위 상황이 아니면 계속 유지되는 객체
		// -> 세션은 로그인한 사람의 정보를 담아둠

		// 1) session scope 객체 얻어오기(본인보다 더 작은 객체에서 얻어올 수 있음)
		// -> 즉, 더 작은 객체는 request

		HttpSession session = request.getSession();
		session.setAttribute("sessionValue", "session scope 객체에 세팅한 값");
		// sessionValue = session scope 객체에 세팅한 값

		// 4. application scope
		// - 서버 전체에 1개만 존재하는 객체
		// -> 즉, 모든 클라이언트가 공유하는 객체다
		// 서버 시작 시 생성되고, 서버가 종료시 소멸된다.
		// 그 전까지는 유효한 범위를 가짐
		// session or request에서 얻어올 수 있음

		// 1) application scope 객체 얻어오기
		ServletContext application = request.getServletContext();

		// 2) application scope 값 세팅
		application.setAttribute("applicationValue", "application scope 객체에 세팅한 값");
		// applicationValue = application scope 객체에 세팅한 값

		// ---------------------------------

		// 범위별 우선순위 확인!!!
		// 좁은 범위가 우선순위가 높다!
		// page > request > session > application

		// key값을 동일하게 하여 범위별 객체에 값 추가
		request.setAttribute("menu", "짬뽕(reqeust)");
		session.setAttribute("menu", "짜장(session)");
		application.setAttribute("menu", "볶음밥(application)");
		// ------------------------------------------------
		// 응답 처리
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/el/scope.jsp");
		dispatcher.forward(request, response);
	}
}
