package com.nts.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.todo.dao.TodoDao;
import com.nts.todo.dto.TodoDto;

@WebServlet("/todo-add")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoDto getTodo(HttpServletRequest request) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));

		TodoDto todo = new TodoDto();
		todo.setTitle(title);
		todo.setName(name);
		todo.setSequence(sequence);

		return todo;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 매개변수로 전달되는 데이터의 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=UTF-8");

		try {
			TodoDto todo = getTodo(request);
			TodoDao todoDao = new TodoDao();
			todoDao.addTodo(todo);

			response.sendRedirect("./main");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
			response.getOutputStream().println("<script>"
					+ "alert('Todo 추가 싫패\n 메인페이지로 이동합니다.');"
					+ "location.href='/main';"
					+ "</script>");
		}
	}

}
