package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 왜 index.jsp에서 메인페이지 코드를 작성하지 않고
		// /main 요청을 처리하는 서블릿을 만들었는가?
		// -> Servlet(Java 코드 <-> DB)에서 추가한 데이터(DB에서 조회한)를

		// 메인페이지에서부터 사용할 수 있게 하기 위해
		// DB에 갔다오는 일!
		// 요청 -> Controller(Servlet) -> service -> DAO -> DB
		// 응답 <- views(jsp) <- <- <-

		try {
			TodoListService service = new TodoListServiceImpl();
			// interface는 객체를 생성할 수 없기 때문에 자식으로 new 해줌

			// 전체 할 일 목록 + 완료된 Todo 갯수
			Map<String, Object> map = service.todoListFullView();

			// Map에 저장된 값 풀어내기
			List<Todo> todoList = (List<Todo>) map.get("todoList");
			int completeCount = (int) map.get("completeCount");

			// request scope에 객체 값 추가하기
			request.setAttribute("todoList", todoList);
			request.setAttribute("completeCount", completeCount);

			// 메인페이지 응답을 담당하는 JSP에 요청 위임
			request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
