package com.nts.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.exception.CustomException;
import com.nts.todo.dao.TodoDao;
import com.nts.todo.dto.TodoDto;

@WebServlet("/todo-add")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, CustomException {
		// 매개변수로 전달되는 데이터의 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=UTF-8");

		try {
			ServletContext servletContext = this.getServletContext();
			TodoDao todoDao = (TodoDao) servletContext.getAttribute("dao");
			TodoDto todo = getTodo(request);
			todoDao.addTodo(todo);

			response.sendRedirect("./main");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomException("Todo를 추가하는데 문제가 발생했습니다.");
		}
	}

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
}
