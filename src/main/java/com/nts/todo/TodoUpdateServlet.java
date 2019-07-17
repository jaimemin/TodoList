package com.nts.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.exception.CustomException;
import com.nts.todo.dao.TodoDao;
import com.nts.todo.dto.TodoDto;

@WebServlet("/todo-update")
public class TodoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final List<String> TYPE = new ArrayList<>(Arrays.asList("TODO", "DOING"));

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, CustomException {
		response.setContentType("text/plain;charset=UTF-8");

		try {
			TodoDao todoDao = TodoDao.getInstance();
			TodoDto todo = getTodo(request);

			todoDao.updateTodo(todo);
		} catch (SQLException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new CustomException("업데이트 하는 과정에서 예외가 발생했습니다.\n" + e.getMessage());
		}
	}

	private TodoDto getTodo(HttpServletRequest request) {
		long id = Long.parseLong(request.getParameter("id"));
		String status = request.getParameter("status");
		String changedStatus;

		if (TYPE.contains(status) == false) {
			throw new IllegalArgumentException("type에 알 수 없는 값이 저장되어있습니다.");
		}

		changedStatus = (status.equals("TODO")) ? "DOING" : "DONE";

		TodoDto todo = new TodoDto();
		todo.setType(changedStatus);
		todo.setId(id);

		return todo;
	}

}
