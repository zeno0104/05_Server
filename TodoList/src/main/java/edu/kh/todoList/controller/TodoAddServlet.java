package edu.kh.todoList.controller;

import java.io.IOException;

import static edu.kh.todoList.common.JDBCTemplate.*;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/add")
public class TodoAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 1. TodoListServiceImpl 객체 생성
			TodoListService service = new TodoListServiceImpl();

			// 2. 요청 시 전달받은 파라미터 데이터 얻어오기
			String title = request.getParameter("title"); // 제목
			String detail = request.getParameter("detail"); // 상세내용

			// 3. 서비스 호출 후 결과 반환하기
			int result = service.todoAdd(title, detail);

			// 4. 성공/실패 메세지 세팅하기
			String message = null;

			if (result > 0)
				message = "추가 성공!!!";
			else
				message = "추가 실패...";

			// 5. 기존 request를 사용할 수 없기 때문에
			// session을 이용해서 message를 세팅
			HttpSession session = request.getSession();
			session.setAttribute("message", message);
			
			// 6. 메인페이지로 redirect (재요청)
			response.sendRedirect("/");
			// -> "/" 최상위 경로로 재요청 보냄
			// -> "/" 처리하는 Servlet/JSP 재요청
			// -> /면 index.jsp가 받아들임 => 하지만, 애초에 forward로 /main이 받음
			// => 따라서 "/"도 가능하고 "/main"도 가능
			// -> redirect는 무조건 GET 방식!
			// => 따라서, 위임받는 경로에 doGet이 있는지 확인해야한다.

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
