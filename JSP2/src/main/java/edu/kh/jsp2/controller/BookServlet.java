package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp2.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 요청 
		
		// BookList
		// Book으로 타입이 제한된 Lsit 생성
		
		List<Book> bookList = new ArrayList<Book>();
		
		// bookList에 데이터 추가
		
		// => 객체를 list에 한번에 넣을 수 있도록 코드 짜기!✔✔
		
		Book book1 = new Book("자바란 무엇인가", "둘리", 10000);
		Book book2 = new Book("HTML이란 무엇인가", "홍길동", 20000);
		Book book3 = new Book("JS란 무엇인가", "이순신", 15000);
		Book book4 = new Book("CSS란 무엇인가", "짱구", 50000);
		Book book5 = new Book("Servlet이란 무엇인가", "훈이", 40000);
		Book book6 = new Book("JSP란 무엇인가", "철수", 80000);
		Book book7 = new Book("Sptring이란 무엇인가", "유리", 60000);
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		bookList.add(book5);
		bookList.add(book6);
		bookList.add(book7);
		
		
		// bookList를 요청 위임된 JSP에서도 유지하여 사용할 수 있도록
		// request scope 객체에 속성으로 추가(세팅)
		request.setAttribute("bookList", bookList);
		
		
		// 응답
		// JSP로 요청 위임(webapp 폴더 기준)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp");
		dispatcher.forward(request, response);
		
	}
}
