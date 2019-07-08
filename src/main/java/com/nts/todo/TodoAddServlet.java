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

@WebServlet("/todoadd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 매개변수로 전달되는 데이터의 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=UTF-8");

		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		
		TodoDto todo = new TodoDto();
		todo.setTitle(title);
		todo.setName(name);
		todo.setSequence(sequence);
		
		TodoDao todoDao = new TodoDao();
		try {
			int insertCount = todoDao.addTodo(todo);
			if (insertCount > 0) {
				response.sendRedirect("/main");
			} else {
				PrintWriter out = response.getWriter();
				out.write("error occured on insert");
				out.close();
			}
		} catch (SQLException e) {
			response.sendRedirect("/WEB-INF/jsp/error.jsp");
		}
	}

}
