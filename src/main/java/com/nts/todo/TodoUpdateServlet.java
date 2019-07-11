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

		switch (status) {
		case "TODO":
			changedStatus = "DOING";
			break;
		case "DOING":
			changedStatus = "DONE";
			break;
		default:
			throw new IllegalArgumentException("illegal parameter");
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
			int updatedCount = todoDao.updateTodo(todo);

			if (updatedCount < 1) {
				System.out.println("error occured on update");
				return;
			}
		} catch (SQLException e) {
			System.out.println("SQLException 발생");
			throw new RuntimeException(e);
		} catch (NullPointerException e2) {
			System.out.println("NullPointerException 발생");
			throw new RuntimeException(e2);
		} catch (IllegalArgumentException e3) {
			System.out.println("IllegalArguementException 발생");
			throw new RuntimeException(e3);
		}
	}

}
