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

@WebServlet("/todo-update")
public class TodoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoDto getTodo(HttpServletRequest request) {
		long id = Long.parseLong(request.getParameter("id"));
		String status = request.getParameter("status");
		String changedStatus = "";
		System.out.println("status: " + status);
		/*
		 * 서비스 지속성을 위해 status가 invalid한 값이면 type을 TODO로
		 */
		if (!(status.equals("TODO") || status.equals("DOING"))) {
			changedStatus = "TODO";
		}

		if (changedStatus == "") {
			changedStatus = (status.equals("TODO")) ? "DOING" : "DONE";
		}

		TodoDto todo = new TodoDto();
		todo.setType(changedStatus);
		todo.setId(id);

		return todo;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");

		try {
			TodoDto todo = getTodo(request);
			TodoDao todoDao = new TodoDao();
			todoDao.updateTodo(todo);
		} catch (SQLException e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

}
