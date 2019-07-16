package com.nts.todo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.exception.CustomException;
import com.nts.todo.dao.TodoDao;
import com.nts.todo.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, CustomException {
		try {
			TodoDao todoDao = TodoDao.getInstance();

			List<TodoDto> todoList = new ArrayList<>();
			List<TodoDto> doingList = new ArrayList<>();
			List<TodoDto> doneList = new ArrayList<>();

			for (TodoDto todo : todoDao.getTodos()) {
				switch (todo.getType()) {
				case "TODO":
					todoList.add(todo);
					break;
				case "DOING":
					doingList.add(todo);
					break;
				case "DONE":
					doneList.add(todo);
					break;
				}
			}

			request.setAttribute("todoList", todoList);
			request.setAttribute("doingList", doingList);
			request.setAttribute("doneList", doneList);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomException("데이터베이스에서 데이터를 불러오는데 문제가 발생했습니다.");
		}
	}

}
