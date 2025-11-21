package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/complete")
public class CompleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			TodoListService service = new TodoListServiceImpl();
			int todoNo = Integer.parseInt(request.getParameter("todoNo"));

			// 할일 여부를 변경하는 서비스 호출 후 결과 반환받기
			int result = service.todoComplete(todoNo);

			// result 값이 0보다 크다 == 변경 성공
			// -> 원래 보고 있던 상세 페이지로 redirect
			// -> message "완료 여부가 변경되었습니다!"

			HttpSession session = request.getSession();

			if (result > 0) {
				session.setAttribute("message", "완료 여부가 변경되었습니다!");
				response.sendRedirect("/todo/detail?todoNo=" + todoNo);
				return;
			}
			// 변경 실패 시
			// -> 메인 페이지로 redireect
			// -> message "todo 가 존재하지 않습니다."
			// todoNo가 없는 경우에 실패!
			session.setAttribute("message", "todo가 존재하지 않습니다");

			response.sendRedirect("/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
