package com.nts.todo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.todo.dao.TodoDao;
import com.nts.todo.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoDao todoDao = new TodoDao();
		List<TodoDto> todoList;
		try {
			todoList = todoDao.getTodos();
			request.setAttribute("todoList", todoList);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
