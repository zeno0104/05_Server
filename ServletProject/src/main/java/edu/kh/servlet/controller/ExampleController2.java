package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet 관련 코드를 작성하기 위해서는 HttpServlet 클래스 상속 받아야함 
// 상속받았다고해서 바로 Servlet 등록이 되는것은 아님!
// -> 방법1. web.xml 작성하기
//    방법2. @WebServlet() 어노테이션 사용하기

/*
 * 어노테이션 : 컴파일러가 읽는 주석
 * 
 * @WebServlet 어노테이션
 * -> 해당 클래스를 Servlet으로 등록하고 () 안에 작성된 주소와
 * 매핑하라고(연결하라고) 지시하는 어노테이션
 * */
@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet {
	// Post 요청 처리 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청시 제출받은 데이터 얻어오기
		String userId = request.getParameter("inputId");
		String userPw = request.getParameter("inputPw");
		String userName = request.getParameter("inputName");
		String intro = request.getParameter("intro");

		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(userName);
		System.out.println(intro);
		// 응답화면 만들기
		// -> Java에서 응답화면을 작성하기 번거롭고 힘들다..
		// -> JSP가 대신 화면을 만들어달라!
		// -> Servlet이 JSP에게 요청/응답을 위임
		// JSP가 대신 응답화면을 만들어주기 위해서는
		// Servlet이 어떤 요청을 받았는지 알아야한다(req, resp)

		// result.jsp에게 위임하는 것

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/result.jsp");
		// 경로는 webapp 폴더 기준으로 작성
		// 즉, 위임하려는 jsp 폴더 경로를 작성해주는 것

		// -> webapp 폴더는 웹 애플리케이션의 루트(root) 디렉토리로,
		// 브라우저를 통해 접근 가능한 정적 / 동적 리소스들이 위치하는 폴더
		// -> webapp 폴더가 컨텍스트 루트(/)로 설정되기 때문에,
		// 해당 경로가 webapp 내부 경로로 해석되는 것.

		// WEB-INF 폴더에 있는 파일들은 클라이언트가 url로 직접 접근할 수 없는 영역,
		// 서블릿을 통해서만 접근 가능

		dispatcher.forward(request, response);
		// 요청 전달, 즉 요청을 위임하는 것
		// dispatcher는 요청을 전달할 때, 중간다리를 놓는 알바생?
		// 즉, JSP에게 request, response를 JSP에게 전달

		// ReqeustDispatcher 객체를 이용하여 현재 요청(req)와 응답(resp)을
		// 지정한 JSP 페이지(result.jsp)로 전달하는 작업
		// -> 즉, 현재 서블릿(ExampleController2)에서 처리하던 요청을
		// result.jsp로 전달하고 제어권을 jsp쪽으로 넘김(== 위임한다고 표현)
	}
}