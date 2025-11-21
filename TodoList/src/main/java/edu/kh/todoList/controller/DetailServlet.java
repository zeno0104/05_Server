package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/detail")
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 할 일 상세 조회 요청 처리

		try {
			// 서비스 객체 생성
			TodoListService service = new TodoListServiceImpl();
			
			// 요청 시 전달받은 파라미터 얻어오기
			int todoNo = Integer.parseInt(request.getParameter("todoNo"));
			
			// 알맞은 서비스 호출 후 결과 반환 받기
			Todo todo = service.todoDetail(todoNo);
			// TODO_NO 컬럼값이 todoNo와 같은 행이 있으면
			// 해당 행의 데이터를 Todo 객체에 담아 반환
			// 없으면 null 반환
			
			// todo가 존재하지 않을 경우
			// -> 메인펲이지 redirect 후
			// "할 일이 존재하지 않습니다" alert 출력
			
			
			if(todo == null) {
				HttpSession session = request.getSession();
				
				// session 객체 생성 후 message 세팅하기
				session.setAttribute("message", "할 일이 존재하지 않습니다.");
				response.sendRedirect("/");
				return;
			}
			
			// todo가 존재하는 경우
			// detail.jsp
			request.setAttribute("todo", todo);
			request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
