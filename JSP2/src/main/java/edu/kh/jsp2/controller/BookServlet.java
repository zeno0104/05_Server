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
		
		List<Book> bookList = new ArrayList<Book>();
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
		
		request.setAttribute("bookList", bookList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp");
		dispatcher.forward(request, response);
		
	}
}
