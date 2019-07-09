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

@WebServlet("/todo-update/*")
public class TodoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] path = pathInfo.split("/");
			String status = (path[1].equals("TODO")) ? "DOING" : "DONE";
			long id = Long.parseLong(path[2]);

			TodoDto todo = new TodoDto();
			todo.setType(status);
			todo.setId(id);

			TodoDao todoDao = new TodoDao();
			try {
				int updatedCount = todoDao.updateTodo(todo);

				String state;
				if (updatedCount > 0) {
					state = "updated";
				} else {
					state = "failed";
				}

				PrintWriter out = response.getWriter();
				out.write(state);
				out.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} else {
			PrintWriter out = response.getWriter();
			out.write("error occured on update");
			out.close();
		}
	}

}
