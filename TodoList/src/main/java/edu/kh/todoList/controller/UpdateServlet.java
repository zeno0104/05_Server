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

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 수정 화면에는 기존의 제목, 상세 내용이
			// input, textarea에 채워져있는 상태여야한다!
			// -> 수정 전 제목/내용 조회

			TodoListService service = new TodoListServiceImpl();

			int todoNo = Integer.parseInt(request.getParameter("todoNo"));

			Todo todo = service.todoDetail(todoNo);
			if (todo == null) {
				// 메인페이지 redirect
				response.sendRedirect("/");
				return;
			}

			request.setAttribute("todo", todo);
			request.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 요청 주소가 같을 때 데이터 제출 방식이 다르면(GET/POST) 하나의 서블릿 클래스에서 각각의 메서드
	 * (doGet()/doPost())를 만들어 처리할 수 있다.
	 */

	// 할 일 제목/내용 수정 POST 요청
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
			int todoNo = Integer.parseInt(request.getParameter("todoNo"));

			TodoListService service = new TodoListServiceImpl();

			int result = service.todoUpdate(todoNo, title, detail);

			// 수정 성공 시
			// 상세 조회 페이지로 redirect
			// "수정되었습니다" message를 출력

			// 수정 실패 시
			// 수정 화면으로 redirect
			// "수정 실패" message를 출력
			String url = null;
			String message = null;


			if (result > 0) { // 성공
				message = "수정 되었습니다";
				url = "/todo/detail?todoNo=" + todoNo;
			} else { // 실패
				message = "수정 실패";
				url = "/todo/update?todoNo=" + todoNo;
			}
			HttpSession session = request.getSession();
			session.setAttribute("message", message);
			
			response.sendRedirect(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
